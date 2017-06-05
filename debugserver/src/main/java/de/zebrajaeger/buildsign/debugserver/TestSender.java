package de.zebrajaeger.buildsign.debugserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJobBuild;
import de.zebrajaeger.buildsign.notification.Phase;
import de.zebrajaeger.buildsign.notification.Scm;
import de.zebrajaeger.buildsign.notification.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Lars Brandt
 */
@SuppressWarnings("classfanoutcomplexity")
public class TestSender extends JFrame {

    private static final Logger LOG = LoggerFactory.getLogger(TestSender.class);
    public static final String DEFAULT_PROJECT = "BuildSign_Test_Fail";
    public static final String DEFAULT_URL = "http://localhost:9999/notification";

    public static void main(String[] args) {
        new TestSender().setVisible(true);
    }

    private JTextField urlField;
    private JTextField projectNameField;
    private JComboBox<Status> statusField;
    private JComboBox<Phase> phaseField;
    private JButton sendButton;

    public TestSender() throws HeadlessException {
        super("TestSender");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        int pos = 0;
        addField(getUrlField(), "URL:", pos++);
        addField(getProjectnameField(), "Projectname:", pos++);
        addField(getPhaseField(), "Phase:", pos++);
        addField(getStatusField(), "Status:", pos++);
        addField(getSendButton(), "", pos++);
        pack();
    }

    private void addField(Component field, String label, int row) {
        Insets insets = new Insets(5, 10, 5, 10);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = insets;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = row;
        c.weightx = 0;
        add(new JLabel(label), c);

        c.gridx = 1;
        c.weightx = 1.0;
        add(field, c);
    }

    private JTextField getUrlField() {
        if (urlField == null) {
            urlField = new JTextField(DEFAULT_URL);
        }
        return urlField;
    }

    public String getUrl() {
        return getUrlField().getText();
    }

    private JTextField getProjectnameField() {
        if (projectNameField == null) {
            projectNameField = new JTextField(DEFAULT_PROJECT);
        }
        return projectNameField;
    }

    public String getProjectName() {
        return getProjectnameField().getText();
    }

    private JComboBox<Status> getStatusField() {
        if (statusField == null) {
            Status[] values = new Status[Status.values().length + 1];
            System.arraycopy(Status.values(), 0, values, 1, Status.values().length);
            statusField = new JComboBox(values);
            statusField.setSelectedItem(Status.SUCCESS);
        }
        return statusField;
    }

    public Status getStatus() {
        return (Status) getStatusField().getSelectedItem();
    }

    private JComboBox<Phase> getPhaseField() {
        if (phaseField == null) {
            Phase[] values = new Phase[Phase.values().length + 1];
            System.arraycopy(Phase.values(), 0, values, 1, Phase.values().length);

            phaseField = new JComboBox(values);
            phaseField.setSelectedItem(Phase.FINALIZED);
        }
        return phaseField;
    }

    public Phase getPhase() {
        return (Phase) getPhaseField().getSelectedItem();
    }

    private JButton getSendButton() {
        if (sendButton == null) {
            sendButton = new JButton("Send");
            sendButton.addActionListener(e -> onSend(e));
        }
        return sendButton;
    }

    private void onSend(ActionEvent event) {
        JenkinsNotificationJob job = new JenkinsNotificationJob();
        job.setName(getProjectName());
        job.setUrl("job/" + getProjectName());

        JenkinsNotificationJobBuild build = new JenkinsNotificationJobBuild();
        build.setNumber(0);
        build.setQueueId("5");
        build.setPhase(getPhase());
        build.setStatus(getStatus());
        build.setLog("nothing");
        job.setBuild(build);

        Scm scm = new Scm();
        scm.setUrl("git@github.com:zebrajaeger/BuildSign.git");
        scm.setBranch("origin/master");
        scm.setCommit("ea978cec662a61a19ab4fac4290df2c0370a8679");
        build.setScm(scm);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String postData = gson.toJson(job);
        LOG.info("Send Data: {}", postData);
        try {
            URL url = new URL(getUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            LOG.info("response code: '{}'", con.getResponseCode());
        } catch (IOException e) {
            LOG.error("could not open url: '{}'", getUrl(), e);
        }
    }
}
