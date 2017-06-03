package de.zebrajaeger.buildsign.display;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lars Brandt
 */
public class Version {
    public static final Pattern PATTERN = Pattern.compile("(\\d+)(\\.(\\d+))?(\\.(\\d+))?");

    private int major;
    private int minor;
    private int bugfix;

    public Version(String value) {
        Matcher matcher = PATTERN.matcher(value);
        if (matcher.matches()) {
            String temp;

            // major
            temp = matcher.group(1);
            major = Integer.parseInt(temp);

            //minor
            temp = matcher.group(3);
            if (temp != null) {
                minor = Integer.parseInt(temp);
            }

            //bugix
            temp = matcher.group(5);
            if (temp != null) {
                bugfix = Integer.parseInt(temp);
            }

        } else {
            throw new IllegalArgumentException("Value '" + value + "'doesn't match pattern '" + PATTERN + "'");
        }
    }

    public Version(int major, int minor, int bugfix) {
        this.major = major;
        this.minor = minor;
        this.bugfix = bugfix;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getBugfix() {
        return bugfix;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + bugfix;
    }
}
