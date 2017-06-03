package de.zebrajaeger.buildsign.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.zebrajaeger.buildsign.Bus;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;
import de.zebrajaeger.buildsign.utils.StreamUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Lars Brandt
 */
public class NotificationHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
        String body = StreamUtils.stringFromInputStream(he.getRequestBody());
        JenkinsNotificationJob job = new Gson().fromJson(body, JenkinsNotificationJob.class);
        Bus.post(job);

        he.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
        String response = "thx";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
