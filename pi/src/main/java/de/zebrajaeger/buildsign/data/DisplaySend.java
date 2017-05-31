package de.zebrajaeger.buildsign.data;

import de.zebrajaeger.buildsign.DataSend;

/**
 * typedef struct {<br>
 * uint8_t scroll_delay;<br>
 * uint8_t scroll_direction;<br>
 * uint8_t percent_of_previous;<br>
 * <br>
 * uint8_t offset_r;<br>
 * uint8_t offset_g;<br>
 * uint8_t offset_b;<br>
 * uint8_t offset_w;<br>
 * uint8_t random_r;<br>
 * uint8_t random_g;<br>
 * uint8_t random_b;<br>
 * uint8_t random_w;<br>
 * <br>
 * uint8_t random_point_count;<br>
 * uint8_t random_point_offset_r;<br>
 * uint8_t random_point_offset_g;<br>
 * uint8_t random_point_offset_b;<br>
 * uint8_t random_point_offset_w;<br>
 * uint8_t random_point_random_r;<br>
 * uint8_t random_point_random_g;<br>
 * uint8_t random_point_random_b;<br>
 * uint8_t random_point_random_w;<br>
 * } msg_t;
 *
 * @author Lars Brandt
 */
public class DisplaySend implements DataSend {

    private DisplayValues values;

    public DisplaySend(DisplayValues values) {
        this.values = values;
    }

    protected byte toByte(int i) {
        return (byte) i;
    }

    @Override
    public byte[] getValues() {
        byte[] d = new byte[20];

        d[0x00] = toByte(values.getScrollDelay());
        d[0x01] = toByte(values.getScrollDirection());
        d[0x02] = toByte(values.getPercentOfPrevious());

        d[0x03] = toByte(values.getOffsetR());
        d[0x04] = toByte(values.getOffsetG());
        d[0x05] = toByte(values.getOffsetB());
        d[0x06] = toByte(values.getOffsetW());
        d[0x07] = toByte(values.getRandomR());
        d[0x08] = toByte(values.getRandomG());
        d[0x09] = toByte(values.getRandomB());
        d[0x0a] = toByte(values.getRandomW());

        d[0x0b] = toByte(values.getRandomPointCount());
        d[0x0c] = toByte(values.getRandomPointOffsetR());
        d[0x0d] = toByte(values.getRandomPointOffsetG());
        d[0x0e] = toByte(values.getRandomPointOffsetB());
        d[0x0f] = toByte(values.getRandomPointOffsetW());
        d[0x10] = toByte(values.getRandomPointRandomR());
        d[0x11] = toByte(values.getRandomPointRandomG());
        d[0x12] = toByte(values.getRandomPointRandomB());
        d[0x13] = toByte(values.getRandomPointRandomW());

        return d;
    }
}
