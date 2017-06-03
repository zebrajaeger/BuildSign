package de.zebrajaeger.buildsign.notification;

import com.google.gson.annotations.SerializedName;

/**
 * @author Lars Brandt
 */
public class JenkinsNotificationJobBuild {
    private Integer number;
    @SerializedName("queue_id")
    private String queueId;
    private Phase phase;
    private Status status;
    private Scm scm;
    private String log;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Scm getScm() {
        return scm;
    }

    public void setScm(Scm scm) {
        this.scm = scm;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }


}
