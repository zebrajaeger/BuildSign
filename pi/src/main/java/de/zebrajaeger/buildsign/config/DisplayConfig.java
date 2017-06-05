package de.zebrajaeger.buildsign.config;

import java.util.List;
import java.util.Objects;

/**
 * @author Lars Brandt
 */
public class DisplayConfig {
    private Multiplyer multiplyer;
    private List<Display> displays;

    public Multiplyer getMultiplyer() {
        return multiplyer;
    }

    public List<Display> getDisplays() {
        return displays;
    }

    public Display findDisplay(String id) {
        for (Display d : displays) {
            if (Objects.equals(id, d.getDisplayId())) {
                return d;
            }
        }
        return null;
    }
}
