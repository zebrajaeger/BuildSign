package de.zebrajaeger.buildsign.display;

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
public class DisplayValues {

    private int scrollDelay;
    private int scrollDirection;
    private int percentOfPrevious;

    private int offsetR;
    private int offsetG;
    private int offsetB;
    private int offsetW;
    private int randomR;
    private int randomG;
    private int randomB;
    private int randomW;

    private int randomPointCount;
    private int randomPointOffsetR;
    private int randomPointOffsetG;
    private int randomPointOffsetB;
    private int randomPointOffsetW;
    private int randomPointRandomR;
    private int randomPointRandomG;
    private int randomPointRandomB;
    private int randomPointRandomW;

    public int getScrollDelay() {
        return scrollDelay;
    }

    public void setScrollDelay(int scrollDelay) {
        this.scrollDelay = scrollDelay;
    }

    public int getScrollDirection() {
        return scrollDirection;
    }

    public void setScrollDirection(int scrollDirection) {
        this.scrollDirection = scrollDirection;
    }

    public int getPercentOfPrevious() {
        return percentOfPrevious;
    }

    public void setPercentOfPrevious(int percentOfPrevious) {
        this.percentOfPrevious = percentOfPrevious;
    }

    public int getOffsetR() {
        return offsetR;
    }

    public void setOffsetR(int offsetR) {
        this.offsetR = offsetR;
    }

    public int getOffsetG() {
        return offsetG;
    }

    public void setOffsetG(int offsetG) {
        this.offsetG = offsetG;
    }

    public int getOffsetB() {
        return offsetB;
    }

    public void setOffsetB(int offsetB) {
        this.offsetB = offsetB;
    }

    public int getOffsetW() {
        return offsetW;
    }

    public void setOffsetW(int offsetW) {
        this.offsetW = offsetW;
    }

    public int getRandomR() {
        return randomR;
    }

    public void setRandomR(int randomR) {
        this.randomR = randomR;
    }

    public int getRandomG() {
        return randomG;
    }

    public void setRandomG(int randomG) {
        this.randomG = randomG;
    }

    public int getRandomB() {
        return randomB;
    }

    public void setRandomB(int randomB) {
        this.randomB = randomB;
    }

    public int getRandomW() {
        return randomW;
    }

    public void setRandomW(int randomW) {
        this.randomW = randomW;
    }

    public int getRandomPointCount() {
        return randomPointCount;
    }

    public void setRandomPointCount(int randomPointCount) {
        this.randomPointCount = randomPointCount;
    }

    public int getRandomPointOffsetR() {
        return randomPointOffsetR;
    }

    public void setRandomPointOffsetR(int randomPointOffsetR) {
        this.randomPointOffsetR = randomPointOffsetR;
    }

    public int getRandomPointOffsetG() {
        return randomPointOffsetG;
    }

    public void setRandomPointOffsetG(int randomPointOffsetG) {
        this.randomPointOffsetG = randomPointOffsetG;
    }

    public int getRandomPointOffsetB() {
        return randomPointOffsetB;
    }

    public void setRandomPointOffsetB(int randomPointOffsetB) {
        this.randomPointOffsetB = randomPointOffsetB;
    }

    public int getRandomPointOffsetW() {
        return randomPointOffsetW;
    }

    public void setRandomPointOffsetW(int randomPointOffsetW) {
        this.randomPointOffsetW = randomPointOffsetW;
    }

    public int getRandomPointRandomR() {
        return randomPointRandomR;
    }

    public void setRandomPointRandomR(int randomPointRandomR) {
        this.randomPointRandomR = randomPointRandomR;
    }

    public int getRandomPointRandomG() {
        return randomPointRandomG;
    }

    public void setRandomPointRandomG(int randomPointRandomG) {
        this.randomPointRandomG = randomPointRandomG;
    }

    public int getRandomPointRandomB() {
        return randomPointRandomB;
    }

    public void setRandomPointRandomB(int randomPointRandomB) {
        this.randomPointRandomB = randomPointRandomB;
    }

    public int getRandomPointRandomW() {
        return randomPointRandomW;
    }

    public void setRandomPointRandomW(int randomPointRandomW) {
        this.randomPointRandomW = randomPointRandomW;
    }
}
