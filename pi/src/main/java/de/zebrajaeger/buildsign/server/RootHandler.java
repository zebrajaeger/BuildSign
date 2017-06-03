package de.zebrajaeger.buildsign.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Lars Brandt
 */
public class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("    <title>BuildSign</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("    <h1>").append("BuildSign").append("</h1>");
        sb.append("    <h2>").append("notification url: <a href=\"notification\">notification</a>").append("</h2>");
        sb.append("</body>");
        sb.append("</html>");
        he.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
        String response = sb.toString();
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
