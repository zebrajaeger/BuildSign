package de.zebrajaeger.buildsign;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;

/**
 * @author Lars Brandt
 */
public class DisplayChanger {
    private Config config;

    public DisplayChanger(Config config, EventBus eventBus) {
        this.config = config;
        eventBus.register(this);
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onNotification(JenkinsNotificationJob notification) {
        // TODO implement me
    }
}
