package de.zebrajaeger.buildsign;

import com.pi4j.io.i2c.I2CDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class Device {
    private static final Logger LOG = LoggerFactory.getLogger(Device.class);

    private Connection connection;
    private int address;
    private I2CDevice device;

    public Device(Connection connection, int address) {
        this.connection = connection;
        this.address = address;
    }

    private I2CDevice getDevice() throws IOException {
        if (device == null) {
            device = connection.getI2cbus().getDevice(address);
        }
        return device;
    }

    public void send(DataSend dataSend) throws IOException {
        LOG.info("Send display to display: '{}'", dataSend);
        getDevice().write(dataSend.getValues());
    }

    public <T extends DataReceive> T receive(Class<T> dataClass) throws IOException, BuildSignException {
        try {
            DataReceive dataReceive = dataClass.newInstance();
            int dataSize = dataReceive.getExpectedSize();

            byte[] buffer = new byte[dataSize];
            int bytesRidden = getDevice().read(buffer, 0, dataSize);
            LOG.info("Read display from display. Count: '{}'", bytesRidden);
            if (bytesRidden != dataSize) {
                throw new BuildSignException(String.format(
                        "Got not enough DataSend for class: '%s'. ExpectedSize: '%s' bot got only: '%s'",
                        dataClass, dataSize, bytesRidden));
            }
            LOG.info("Got enough display. create object.");
            dataReceive.setValues(buffer);
            return (T) dataReceive;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("Could not create instance of: '%s'", dataClass), e);
        }
    }
}
