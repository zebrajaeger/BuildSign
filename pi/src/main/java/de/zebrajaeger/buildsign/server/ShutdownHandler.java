package de.zebrajaeger.buildsign.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class ShutdownHandler implements HttpHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ShutdownHandler.class);

    @Override
    public void handle(HttpExchange he) throws IOException {
        LOG.info("Shutting down.");
        System.exit(0);
    }
}
