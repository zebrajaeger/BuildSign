package de.zebrajaeger.buildsign.config;

import java.util.List;

/**
 * @author Lars Brandt
 */
public class DisplayConfig {
    private Multiplyer defaultMultiplyer;
    private List<Display> displays;

    public Multiplyer getDefaultMultiplyer() {
        return defaultMultiplyer;
    }

    public List<Display> getDisplays() {
        return displays;
    }
}
