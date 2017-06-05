package de.zebrajaeger.buildsign.changer;

import com.google.common.eventbus.EventBus;
import de.zebrajaeger.buildsign.App;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.display.DisplaySend;
import de.zebrajaeger.buildsign.display.DisplayValues;
import de.zebrajaeger.buildsign.i2c.Connection;
import de.zebrajaeger.buildsign.i2c.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class DisplayChanger extends DisplayChangerBase {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private Connection connection;

    public DisplayChanger(Config config, EventBus eventBus, Connection connection) {
        super(config, eventBus);
        this.connection = connection;
    }

    @Override
    protected void send(int i2cAddress, DisplayValues values) {
        Device d = new Device(connection, i2cAddress);
        try {
            d.send(new DisplaySend(values));
        } catch (IOException e) {
            LOG.error("Could not change light", e);
        }
    }
}
