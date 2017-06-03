package de.zebrajaeger.buildsign.display;

/**
 * @author Lars Brandt
 */
public class DisplayInfo {

    private int i2cAddress;
    private DisplayType displayType;
    private Version version;
    private int messageLength;

    public DisplayType getDisplayType() {
        return displayType;
    }

    public int getI2cAddress() {
        return i2cAddress;
    }

    public void setI2cAddress(int i2cAddress) {
        this.i2cAddress = i2cAddress;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(int messageLength) {
        this.messageLength = messageLength;
    }

    @Override
    public String toString() {
        return "DisplayInfoReceive{"
                + "i2cAddress=" + i2cAddress
                + "displayType=" + displayType
                + ", version=" + version
                + ", messageLength=" + messageLength
                + '}';
    }
}
