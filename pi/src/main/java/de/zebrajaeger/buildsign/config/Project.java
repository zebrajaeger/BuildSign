package de.zebrajaeger.buildsign.config;

import java.util.List;

/**
 * @author Lars Brandt
 */
public class Project {
    private String jenkinsProjectName;
    private String description;
    private String defaultDisplayId;
    private List<Trigger> triggers;

    public String getJenkinsProjectName() {
        return jenkinsProjectName;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultDisplayId() {
        return defaultDisplayId;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }
}
