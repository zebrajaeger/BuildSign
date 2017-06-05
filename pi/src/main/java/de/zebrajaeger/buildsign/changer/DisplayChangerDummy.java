package de.zebrajaeger.buildsign.changer;

import com.google.common.eventbus.EventBus;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.display.DisplayValues;

/**
 * @author Lars Brandt
 */
public class DisplayChangerDummy extends DisplayChangerBase {
    public DisplayChangerDummy(Config config, EventBus eventBus) {
        super(config, eventBus);
    }

    @Override
    protected void send(int i2cAddress, DisplayValues values) {
        // nothing to do
    }
}
