package de.zebrajaeger.buildsign;

/**
 * @author Lars Brandt
 */
public interface DataReceive {
    void setValues(byte[] value);

    int getExpectedSize();
}
