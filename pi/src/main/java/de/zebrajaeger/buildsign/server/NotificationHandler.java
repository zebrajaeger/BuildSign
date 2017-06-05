package de.zebrajaeger.buildsign.server;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Lars Brandt
 */
public class NotificationHandler implements HttpHandler {
    private EventBus eventBus;

    public NotificationHandler(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handle(HttpExchange he) throws IOException {
        String body = IOUtils.toString(he.getRequestBody(), StandardCharsets.UTF_8);
        JenkinsNotificationJob job = new Gson().fromJson(body, JenkinsNotificationJob.class);
        eventBus.post(job);

        he.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
        String response = "thx";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
