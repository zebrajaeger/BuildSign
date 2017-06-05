package de.zebrajaeger.buildsign.config;

import de.zebrajaeger.buildsign.display.DisplayValues;

import java.util.List;

/**
 * @author Lars Brandt
 */
public class TriggerConfig {
    private DisplayValues values;
    private List<Project> projects;

    public DisplayValues getValues() {
        return values;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project findProjectByName(String name) {
        for (Project p : projects) {
            String jenkinsProjectName = p.getJenkinsProjectName();
            if (jenkinsProjectName != null && jenkinsProjectName.equals(name)) {
                return p;
            }
        }
        return null;
    }
}
