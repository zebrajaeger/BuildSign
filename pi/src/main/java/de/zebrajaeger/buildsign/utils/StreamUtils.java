package de.zebrajaeger.buildsign.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Lars Brandt
 */
public class StreamUtils {
    public static String stringFromInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader r = new InputStreamReader(is)) {
            char[] buffer = new char[1024];
            int l;
            while ((l = r.read(buffer)) > 0) {
                sb.append(buffer, 0, l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
