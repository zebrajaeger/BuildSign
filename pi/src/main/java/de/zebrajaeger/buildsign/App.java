package de.zebrajaeger.buildsign;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.config.ConfigException;
import de.zebrajaeger.buildsign.server.NotificationHttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        try {
            new App().start();
        } catch (Throwable t) {
            LOG.error("Fatal error on startup.", t);
            System.exit(-1);
        }
    }

    private App() {
    }

    private void start() throws IOException, ConfigException {
        LOG.info("Start application.");
        EventBus eventBus = new EventBus("default-bus");
        eventBus.register(this);
        Config config = new Config(new File("."));
        eventBus.post(config);
        new NotificationHttpServer(config, eventBus);
        new DisplayChanger(config, eventBus);
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void deadEvent(DeadEvent event) {
        LOG.error("Received dead event: '{}'", event);
    }


//    public static List<DisplayInfo> findDisplays(Connection connection) {
//        List<DisplayInfo> result = new LinkedList<>();
//
//        // https://www.i2c-bus.org/addressing/
//        for (int i = 0b1000; i < 0b1111000; ++i) {
//            LOG.debug("Check Device @ '{}'", i);
//            Device device = new Device(connection, i);
//            try {
//                DisplayInfo displayInfo = device.receive(DisplayInfoReceive.class).getDisplayInfo();
//                displayInfo.setI2cAddress(i);
//                LOG.info("Found Device @ '{}': '{}'", i, displayInfo);
//                result.add(displayInfo);
//            } catch (IOException e) {
//                // ignore
//            } catch (BuildSignException e) {
//                LOG.error("Error during scan", e);
//            }
//        }
//        return result;
//    }
//
//    public static void main2(String[] args) throws IOException, BuildSignException {
//        LOG.info("<App>");
//        try (Connection connection = new Connection()) {
//            List<DisplayInfo> displays = findDisplays(connection);
//            if (!displays.isEmpty()) {
//                DisplayInfo di = displays.get(0);
//                Display display = new Display(connection, di.getI2cAddress());
//                DisplayValues values = new DisplayValues();
//                values.setScrollDelay(100);
//                values.setRandomPointCount(1);
//                values.setRandomPointRandomB(255);
//                values.setPercentOfPrevious(1);
//
//                display.send(new DisplaySend(values));
//            }
//
//
//            Device d = new Device(connection, 0x12);
//            d.send(new DisplaySend("Moin!!"));
//            DisplayInfoReceive receive = d.receive(DisplayInfoReceive.class);
//
//            //LOG.info("received(bytes): '{}'", receive.getSize());
//            LOG.info("received: '{}'", receive);
//
//        } finally {
//            LOG.info("</app>");
//        }
//    }
}
