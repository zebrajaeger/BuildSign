package de.zebrajaeger.buildsign.config;

import de.zebrajaeger.buildsign.display.DisplayValues;

import java.util.List;

/**
 * @author Lars Brandt
 */
public class TriggerConfig {
    private DisplayValues defaultValues;
    private List<Project> projects;

    public void setDefaultValues(DisplayValues defaultValues) {
        this.defaultValues = defaultValues;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
