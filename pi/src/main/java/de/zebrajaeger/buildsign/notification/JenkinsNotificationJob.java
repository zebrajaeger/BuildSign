package de.zebrajaeger.buildsign.notification;

/**
 * @author Lars Brandt
 */
public class JenkinsNotificationJob {
    private String name;
    private String url;
    private JenkinsNotificationJobBuild build;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JenkinsNotificationJobBuild getBuild() {
        return build;
    }

    public void setBuild(JenkinsNotificationJobBuild build) {
        this.build = build;
    }

}
