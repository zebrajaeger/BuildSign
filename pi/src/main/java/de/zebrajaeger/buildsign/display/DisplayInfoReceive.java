package de.zebrajaeger.buildsign.display;

import de.zebrajaeger.buildsign.i2c.DataReceive;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lars Brandt
 */
public class DisplayInfoReceive implements DataReceive {
    private static final Pattern PATTERN = Pattern.compile("([^:]+):\\sv(\\d+\\.\\d+\\.\\d+)\\smsg\\((\\d{2})\\)");

    private DisplayInfo displayInfo = new DisplayInfo();

    public DisplayInfoReceive() {
    }

    public void setValues(String value) {
        Matcher matcher = PATTERN.matcher(value);

        if (matcher.matches()) {
            displayInfo.setDisplayType(DisplayType.findByName(matcher.group(1)));
            displayInfo.setVersion(new Version(matcher.group(2)));
            displayInfo.setMessageLength(Integer.parseInt(matcher.group(3)));
        } else {
            throw new IllegalArgumentException("Value '" + value + "'doesn't match pattern '" + PATTERN + "'");
        }
    }

    @Override
    public void setValues(byte[] value) {
        setValues(new String(value, StandardCharsets.US_ASCII));
    }

    @Override
    public int getExpectedSize() {
        return 28;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }
}
