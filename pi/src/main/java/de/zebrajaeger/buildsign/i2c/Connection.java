package de.zebrajaeger.buildsign.i2c;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class Connection implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(Connection.class);
    private int busNr = 1;
    private I2CBus i2cbus;

    public Connection() {
        try {
            i2cbus = I2CFactory.getInstance(I2CBus.BUS_1); // Depends onthe RasPI version
            LOG.info("Connected to bus.");
        } catch (IOException e) {
            LOG.error("Could not connect to bus: '{}'", e);
        } catch (I2CFactory.UnsupportedBusNumberException e) {
            LOG.error("Could not connect to bus: '{}'", e);
        }
    }

    public void close() throws IOException {
        if (i2cbus != null) {
            LOG.info("Close bus");
            i2cbus.close();
        } else {
            LOG.info("Close bus -> cannot close, is null.");
        }
    }

    public I2CBus getI2cbus() {
        return i2cbus;
    }
}
