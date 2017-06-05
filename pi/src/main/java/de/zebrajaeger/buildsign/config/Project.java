package de.zebrajaeger.buildsign.config;

import de.zebrajaeger.buildsign.notification.Phase;
import de.zebrajaeger.buildsign.notification.Status;

import java.util.List;
import java.util.Objects;

/**
 * @author Lars Brandt
 */
public class Project {
    private String jenkinsProjectName;
    private String description;
    private String displayId;
    private List<Trigger> triggers;

    public String getJenkinsProjectName() {
        return jenkinsProjectName;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayId() {
        return displayId;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    public Trigger findTrigger(Phase phase, Status status) {
        for (Trigger t : triggers) {
            if (Objects.equals(t.getPhase(), phase) && Objects.equals(t.getStatus(), status)) {
                return t;
            }
        }
        return null;
    }

}
