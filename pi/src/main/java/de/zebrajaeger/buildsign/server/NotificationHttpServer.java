package de.zebrajaeger.buildsign.server;

import com.google.common.eventbus.EventBus;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import de.zebrajaeger.buildsign.config.Config;
import de.zebrajaeger.buildsign.config.User;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Lars Brandt
 */
public class NotificationHttpServer {
    private Config config;
    private final HttpServer server;

    public NotificationHttpServer(Config config, EventBus eventBus) throws IOException {
        this.config = config;

        server = HttpServer.create(new InetSocketAddress(config.getServerConfig().getPort()), 10);
        server.createContext("/", new RootHandler());
        server.createContext("/notification", new NotificationHandler(eventBus));
        HttpContext shutdown = server.createContext("/shutdown", new ShutdownHandler());
        shutdown.setAuthenticator(new BasicAuthenticator("shutdown") {
            @Override
            public boolean checkCredentials(String user, String pwd) {
                User admin = config.getServerConfig().getAdmin();
                return user.equals(admin.getUser()) && pwd.equals(admin.getPassword());
            }
        });
        server.start();
    }
}
