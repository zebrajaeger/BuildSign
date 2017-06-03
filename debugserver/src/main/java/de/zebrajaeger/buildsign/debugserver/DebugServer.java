package de.zebrajaeger.buildsign.debugserver;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import de.zebrajaeger.buildsign.notification.JenkinsNotificationJob;
import de.zebrajaeger.buildsign.utils.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * @author Lars Brandt
 */
public class DebugServer {
    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/", new RootHandler());
        server.start();
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange he) throws IOException {
            System.out.println("------------------------------");
            String body = StreamUtils.stringFromInputStream(he.getRequestBody());
            JenkinsNotificationJob job = new Gson().fromJson(body, JenkinsNotificationJob.class);
            System.out.println(body);
            System.out.println(job);

            String response = "Yo!";
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }
}
