package de.zebrajaeger.buildsign.config;

import de.zebrajaeger.buildsign.display.DisplayValues;
import de.zebrajaeger.buildsign.notification.Phase;
import de.zebrajaeger.buildsign.notification.Status;

/**
 * @author Lars Brandt
 */
public class Trigger {
    private Phase phase;
    private Status status;
    private String displayId;
    private DisplayValues values;

    public Phase getPhase() {
        return phase;
    }

    public Status getStatus() {
        return status;
    }

    public String getDisplayId() {
        return displayId;
    }

    public DisplayValues getValues() {
        return values;
    }
}
