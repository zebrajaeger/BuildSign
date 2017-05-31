package de.zebrajaeger.buildsign.data;

import de.zebrajaeger.buildsign.DataSend;

/**
 * @author Lars Brandt
 */
public class DummySend implements DataSend {

    private byte[] data;

    public DummySend(String data) {
        this.data = data.getBytes();
    }

    @Override
    public byte[] getValues() {
        return data;
    }

    @Override
    public String toString() {
        return new String(data);
    }
}
