package de.zebrajaeger.buildsign;

import de.zebrajaeger.buildsign.data.DisplayInfo;
import de.zebrajaeger.buildsign.data.DisplayInfoReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lars Brandt
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private App() {
    }

    public static List<DisplayInfo> findDisplays(Connection connection) {
        List<DisplayInfo> result = new LinkedList<>();

        // https://www.i2c-bus.org/addressing/
        for (int i = 0b1000; i < 0b1111000; ++i) {
            LOG.debug("Check Device @ '{}'", i);
            Device device = new Device(connection, i);
            try {
                DisplayInfo displayInfo = device.receive(DisplayInfoReceive.class).getDisplayInfo();
                displayInfo.setI2cAddress(i);
                LOG.info("Found Device @ '{}': '{}'", i, displayInfo);
                result.add(displayInfo);
            } catch (IOException e) {
                // ignore
            } catch (BuildSignException e) {
                LOG.error("Error during scan", e);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException, BuildSignException {
        LOG.info("<App>");
        try (Connection connection = new Connection()) {
            findDisplays(connection);

/*
            Device d = new Device(connection, 0x12);
            d.send(new DummySend("Moin!!"));
            DisplayInfoReceive receive = d.receive(DisplayInfoReceive.class);

            //LOG.info("received(bytes): '{}'", receive.getSize());
            LOG.info("received: '{}'", receive);
*/
        } finally {
            LOG.info("</app>");
        }
    }
}
