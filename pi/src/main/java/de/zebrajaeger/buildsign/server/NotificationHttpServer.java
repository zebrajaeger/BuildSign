package de.zebrajaeger.buildsign.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Lars Brandt
 */
public class NotificationHttpServer {
    private int port;
    private final HttpServer server;

    public NotificationHttpServer(int port) throws IOException {
        this.port = port;

        server = HttpServer.create(new InetSocketAddress(port), 10);
        server.createContext("/", new RootHandler());
        server.createContext("/notification", new NotificationHandler());
        server.start();
    }
}
