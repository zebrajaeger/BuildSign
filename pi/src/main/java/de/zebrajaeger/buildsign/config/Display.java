package de.zebrajaeger.buildsign.config;

/**
 * @author Lars Brandt
 */
public class Display {
    private String displayId;
    private String description;
    private int i2caddress;
    private Multiplyer multiplyer;

    public String getDisplayId() {
        return displayId;
    }

    public String getDescription() {
        return description;
    }

    public int getI2caddress() {
        return i2caddress;
    }

    public Multiplyer getMultiplyer() {
        return multiplyer;
    }
}
