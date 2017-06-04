package de.zebrajaeger.buildsign.i2c;

/**
 * @author Lars Brandt
 */
public interface DataReceive {
    void setValues(byte[] value);

    int getExpectedSize();
}
