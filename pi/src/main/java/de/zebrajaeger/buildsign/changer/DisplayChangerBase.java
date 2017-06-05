package de.zebrajaeger.buildsign.changer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.config.Display;
import de.zebrajaeger.buildsign.config.DisplayConfig;
import de.zebrajaeger.buildsign.config.Multiplyer;
import de.zebrajaeger.buildsign.config.Project;
import de.zebrajaeger.buildsign.config.Trigger;
import de.zebrajaeger.buildsign.config.TriggerConfig;
import de.zebrajaeger.buildsign.display.DisplayValues;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJobBuild;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lars Brandt
 */
public abstract class DisplayChangerBase {
    private static final Logger LOG = LoggerFactory.getLogger(DisplayChangerBase.class);
    private final Config config;

    public DisplayChangerBase(Config config, EventBus eventBus) {
        this.config = config;
        eventBus.register(this);
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onNotification(JenkinsNotificationJob notification) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String text = gson.toJson(notification);
        LOG.debug(text);

        TriggerConfig triggerConfig = config.getTriggerConfig();

        // default values for display
        DisplayValues values = triggerConfig.getValues();
        if (values == null) {
            values = DisplayValues.DEFAULT_VALUES;
            LOG.debug("No values in trigger config. Take default: '{}'", values);
        } else {
            values = values.fillWithValues(DisplayValues.DEFAULT_VALUES);
        }

        // find given project
        Project project = triggerConfig.findProjectByName(notification.getName());
        if (project == null) {
            LOG.info("Could not find project with name '{}'", notification.getName());
        } else {
            String displayId = project.getDisplayId();
            JenkinsNotificationJobBuild build = notification.getBuild();

            // find given trigger
            Trigger trigger = project.findTrigger(build.getPhase(), build.getStatus());
            if (trigger == null) {
                LOG.info("Could not find trigger for phase: '{}' and status: '{}'", build.getPhase(), build.getStatus());
            } else {
                // overwrite possibly project display id
                if (trigger.getDisplayId() != null) {
                    LOG.debug("Overwrite displayId: '{}' with '{}'", displayId, trigger.getDisplayId());
                    displayId = trigger.getDisplayId();
                }

                if (trigger.getValues() != null) {
                    values = values.overwriteWithValues(trigger.getValues());
                }

                DisplayConfig displayConfig = config.getDisplayConfig();
                Multiplyer multiplyer = displayConfig.getMultiplyer();
                if (multiplyer == null) {
                    multiplyer = Multiplyer.DEFAULT_MULTIPLYER;
                    LOG.debug("No default multiplyer. Take defaults: '{}'", multiplyer);
                } else {
                    multiplyer = multiplyer.fillWith(Multiplyer.DEFAULT_MULTIPLYER);
                }

                Display display = displayConfig.findDisplay(displayId);
                if (display != null) {
                    int i2caddress = display.getI2caddress();
                    LOG.info("I2C-address is: '{}'", i2caddress);
                    if (display.getMultiplyer() != null) {
                        LOG.debug("Overwrite multiplyer: '{}' with '{}'", multiplyer, display.getMultiplyer());
                        multiplyer = multiplyer.overwriteWith(display.getMultiplyer());
                    }

                    values = values.multiply(multiplyer);

                    LOG.info("Send to: '{}' values: '{}'", i2caddress, values);
                    send(i2caddress, values);

                }
            }
        }
    }

    protected abstract void send(int i2cAddress, DisplayValues values);
}
