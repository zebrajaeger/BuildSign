package de.zebrajaeger.buildsign.display;

import de.zebrajaeger.buildsign.config.Multiplyer;

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
@SuppressWarnings("cyclomaticcomplexity")
public class DisplayValues {

    public static final DisplayValues DEFAULT_VALUES = new DisplayValues(
            100, 0, 75,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0);

    private Integer scrollDelay;
    private Integer scrollDirection;
    private Integer percentOfPrevious;

    private Integer offsetR;
    private Integer offsetG;
    private Integer offsetB;
    private Integer offsetW;
    private Integer randomR;
    private Integer randomG;
    private Integer randomB;
    private Integer randomW;

    private Integer randomPointCount;
    private Integer randomPointOffsetR;
    private Integer randomPointOffsetG;
    private Integer randomPointOffsetB;
    private Integer randomPointOffsetW;
    private Integer randomPointRandomR;
    private Integer randomPointRandomG;
    private Integer randomPointRandomB;
    private Integer randomPointRandomW;

    public DisplayValues() {
    }

    @SuppressWarnings("parameternumber")
    public DisplayValues(int scrollDelay,
                         Integer scrollDirection,
                         Integer percentOfPrevious,
                         Integer offsetR,
                         Integer offsetG,
                         Integer offsetB,
                         Integer offsetW,
                         Integer randomR,
                         Integer randomG,
                         Integer randomB,
                         Integer randomW,
                         Integer randomPointCount,
                         Integer randomPointOffsetR,
                         Integer randomPointOffsetG,
                         Integer randomPointOffsetB,
                         Integer randomPointOffsetW,
                         Integer randomPointRandomR,
                         Integer randomPointRandomG,
                         Integer randomPointRandomB,
                         Integer randomPointRandomW) {
        this.scrollDelay = scrollDelay;
        this.scrollDirection = scrollDirection;
        this.percentOfPrevious = percentOfPrevious;
        this.offsetR = offsetR;
        this.offsetG = offsetG;
        this.offsetB = offsetB;
        this.offsetW = offsetW;
        this.randomR = randomR;
        this.randomG = randomG;
        this.randomB = randomB;
        this.randomW = randomW;
        this.randomPointCount = randomPointCount;
        this.randomPointOffsetR = randomPointOffsetR;
        this.randomPointOffsetG = randomPointOffsetG;
        this.randomPointOffsetB = randomPointOffsetB;
        this.randomPointOffsetW = randomPointOffsetW;
        this.randomPointRandomR = randomPointRandomR;
        this.randomPointRandomG = randomPointRandomG;
        this.randomPointRandomB = randomPointRandomB;
        this.randomPointRandomW = randomPointRandomW;
    }

    public DisplayValues fillWithValues(DisplayValues defaultValues) {
        DisplayValues result = new DisplayValues();

        result.scrollDelay = (scrollDelay != null) ? scrollDelay : defaultValues.scrollDelay;
        result.scrollDirection = (scrollDirection != null) ? scrollDirection : defaultValues.scrollDirection;
        result.percentOfPrevious = (percentOfPrevious != null) ? percentOfPrevious : defaultValues.percentOfPrevious;

        result.offsetR = (offsetR != null) ? offsetR : defaultValues.offsetR;
        result.offsetG = (offsetG != null) ? offsetG : defaultValues.offsetG;
        result.offsetB = (offsetB != null) ? offsetB : defaultValues.offsetB;
        result.offsetW = (offsetW != null) ? offsetW : defaultValues.offsetW;
        result.randomR = (randomR != null) ? randomR : defaultValues.randomR;
        result.randomG = (randomG != null) ? randomG : defaultValues.randomG;
        result.randomB = (randomB != null) ? randomB : defaultValues.randomB;
        result.randomW = (randomW != null) ? randomW : defaultValues.randomW;

        result.randomPointCount = (randomPointCount != null) ? randomPointCount : defaultValues.randomPointCount;
        result.randomPointOffsetR = (randomPointOffsetR != null) ? randomPointOffsetR : defaultValues.randomPointOffsetR;
        result.randomPointOffsetG = (randomPointOffsetG != null) ? randomPointOffsetG : defaultValues.randomPointOffsetG;
        result.randomPointOffsetB = (randomPointOffsetB != null) ? randomPointOffsetB : defaultValues.randomPointOffsetB;
        result.randomPointOffsetW = (randomPointOffsetW != null) ? randomPointOffsetW : defaultValues.randomPointOffsetW;
        result.randomPointRandomR = (randomPointRandomR != null) ? randomPointRandomR : defaultValues.randomPointRandomR;
        result.randomPointRandomG = (randomPointRandomG != null) ? randomPointRandomG : defaultValues.randomPointRandomG;
        result.randomPointRandomB = (randomPointRandomB != null) ? randomPointRandomB : defaultValues.randomPointRandomB;
        result.randomPointRandomW = (randomPointRandomW != null) ? randomPointRandomW : defaultValues.randomPointRandomW;

        return result;
    }

    public DisplayValues overwriteWithValues(DisplayValues toOverwriteWith) {
        DisplayValues result = new DisplayValues();

        result.scrollDelay = (toOverwriteWith.scrollDelay != null) ? toOverwriteWith.scrollDelay : scrollDelay;
        result.scrollDirection = (toOverwriteWith.scrollDirection != null) ? toOverwriteWith.scrollDirection : scrollDirection;
        result.percentOfPrevious = (toOverwriteWith.percentOfPrevious != null) ? toOverwriteWith.percentOfPrevious : percentOfPrevious;

        result.offsetR = (toOverwriteWith.offsetR != null) ? toOverwriteWith.offsetR : offsetR;
        result.offsetG = (toOverwriteWith.offsetG != null) ? toOverwriteWith.offsetG : offsetG;
        result.offsetB = (toOverwriteWith.offsetB != null) ? toOverwriteWith.offsetB : offsetB;
        result.offsetW = (toOverwriteWith.offsetW != null) ? toOverwriteWith.offsetW : offsetW;
        result.randomR = (toOverwriteWith.randomR != null) ? toOverwriteWith.randomR : randomR;
        result.randomG = (toOverwriteWith.randomG != null) ? toOverwriteWith.randomG : randomG;
        result.randomB = (toOverwriteWith.randomB != null) ? toOverwriteWith.randomB : randomB;
        result.randomW = (toOverwriteWith.randomW != null) ? toOverwriteWith.randomW : randomW;

        result.randomPointCount = (toOverwriteWith.randomPointCount != null) ? toOverwriteWith.randomPointCount : randomPointCount;
        result.randomPointOffsetR = (toOverwriteWith.randomPointOffsetR != null) ? toOverwriteWith.randomPointOffsetR : randomPointOffsetR;
        result.randomPointOffsetG = (toOverwriteWith.randomPointOffsetG != null) ? toOverwriteWith.randomPointOffsetG : randomPointOffsetG;
        result.randomPointOffsetB = (toOverwriteWith.randomPointOffsetB != null) ? toOverwriteWith.randomPointOffsetB : randomPointOffsetB;
        result.randomPointOffsetW = (toOverwriteWith.randomPointOffsetW != null) ? toOverwriteWith.randomPointOffsetW : randomPointOffsetW;
        result.randomPointRandomR = (toOverwriteWith.randomPointRandomR != null) ? toOverwriteWith.randomPointRandomR : randomPointRandomR;
        result.randomPointRandomG = (toOverwriteWith.randomPointRandomG != null) ? toOverwriteWith.randomPointRandomG : randomPointRandomG;
        result.randomPointRandomB = (toOverwriteWith.randomPointRandomB != null) ? toOverwriteWith.randomPointRandomB : randomPointRandomB;
        result.randomPointRandomW = (toOverwriteWith.randomPointRandomW != null) ? toOverwriteWith.randomPointRandomW : randomPointRandomW;

        return result;
    }

    public DisplayValues multiply(Multiplyer multiplyer) {
        DisplayValues result = new DisplayValues();
        result.scrollDelay = scrollDelay;
        result.scrollDirection = scrollDirection;
        result.percentOfPrevious = percentOfPrevious;

        result.offsetR = multiplyer.multiplyR(offsetR);
        result.offsetG = multiplyer.multiplyG(offsetG);
        result.offsetB = multiplyer.multiplyB(offsetB);
        result.offsetW = multiplyer.multiplyW(offsetW);
        result.randomR = multiplyer.multiplyR(randomR);
        result.randomG = multiplyer.multiplyG(randomG);
        result.randomB = multiplyer.multiplyB(randomB);
        result.randomW = multiplyer.multiplyW(randomW);

        result.randomPointCount = randomPointCount;


        result.randomPointOffsetR = multiplyer.multiplyR(randomPointOffsetR);
        result.randomPointOffsetG = multiplyer.multiplyG(randomPointOffsetG);
        result.randomPointOffsetB = multiplyer.multiplyB(randomPointOffsetB);
        result.randomPointOffsetW = multiplyer.multiplyW(randomPointOffsetW);

        result.randomPointRandomR = multiplyer.multiplyW(randomPointRandomR);
        result.randomPointRandomG = multiplyer.multiplyW(randomPointRandomG);
        result.randomPointRandomB = multiplyer.multiplyW(randomPointRandomB);
        result.randomPointRandomW = multiplyer.multiplyW(randomPointRandomW);

        return result;
    }

    public Integer getScrollDelay() {
        return scrollDelay;
    }

    public void setScrollDelay(int scrollDelay) {
        this.scrollDelay = scrollDelay;
    }

    public Integer getScrollDirection() {
        return scrollDirection;
    }

    public void setScrollDirection(int scrollDirection) {
        this.scrollDirection = scrollDirection;
    }

    public Integer getPercentOfPrevious() {
        return percentOfPrevious;
    }

    public void setPercentOfPrevious(int percentOfPrevious) {
        this.percentOfPrevious = percentOfPrevious;
    }

    public Integer getOffsetR() {
        return offsetR;
    }

    public void setOffsetR(int offsetR) {
        this.offsetR = offsetR;
    }

    public Integer getOffsetG() {
        return offsetG;
    }

    public void setOffsetG(int offsetG) {
        this.offsetG = offsetG;
    }

    public Integer getOffsetB() {
        return offsetB;
    }

    public void setOffsetB(int offsetB) {
        this.offsetB = offsetB;
    }

    public Integer getOffsetW() {
        return offsetW;
    }

    public void setOffsetW(int offsetW) {
        this.offsetW = offsetW;
    }

    public Integer getRandomR() {
        return randomR;
    }

    public void setRandomR(int randomR) {
        this.randomR = randomR;
    }

    public Integer getRandomG() {
        return randomG;
    }

    public void setRandomG(int randomG) {
        this.randomG = randomG;
    }

    public Integer getRandomB() {
        return randomB;
    }

    public void setRandomB(int randomB) {
        this.randomB = randomB;
    }

    public Integer getRandomW() {
        return randomW;
    }

    public void setRandomW(int randomW) {
        this.randomW = randomW;
    }

    public Integer getRandomPointCount() {
        return randomPointCount;
    }

    public void setRandomPointCount(int randomPointCount) {
        this.randomPointCount = randomPointCount;
    }

    public Integer getRandomPointOffsetR() {
        return randomPointOffsetR;
    }

    public void setRandomPointOffsetR(int randomPointOffsetR) {
        this.randomPointOffsetR = randomPointOffsetR;
    }

    public Integer getRandomPointOffsetG() {
        return randomPointOffsetG;
    }

    public void setRandomPointOffsetG(int randomPointOffsetG) {
        this.randomPointOffsetG = randomPointOffsetG;
    }

    public Integer getRandomPointOffsetB() {
        return randomPointOffsetB;
    }

    public void setRandomPointOffsetB(int randomPointOffsetB) {
        this.randomPointOffsetB = randomPointOffsetB;
    }

    public Integer getRandomPointOffsetW() {
        return randomPointOffsetW;
    }

    public void setRandomPointOffsetW(int randomPointOffsetW) {
        this.randomPointOffsetW = randomPointOffsetW;
    }

    public Integer getRandomPointRandomR() {
        return randomPointRandomR;
    }

    public void setRandomPointRandomR(int randomPointRandomR) {
        this.randomPointRandomR = randomPointRandomR;
    }

    public Integer getRandomPointRandomG() {
        return randomPointRandomG;
    }

    public void setRandomPointRandomG(int randomPointRandomG) {
        this.randomPointRandomG = randomPointRandomG;
    }

    public Integer getRandomPointRandomB() {
        return randomPointRandomB;
    }

    public void setRandomPointRandomB(int randomPointRandomB) {
        this.randomPointRandomB = randomPointRandomB;
    }

    public Integer getRandomPointRandomW() {
        return randomPointRandomW;
    }

    public void setRandomPointRandomW(int randomPointRandomW) {
        this.randomPointRandomW = randomPointRandomW;
    }

    @Override
    public String toString() {
        return "DisplayValues{"
                + "scrollDelay=" + scrollDelay
                + ", scrollDirection=" + scrollDirection
                + ", percentOfPrevious=" + percentOfPrevious
                + ", offsetR=" + offsetR
                + ", offsetG=" + offsetG
                + ", offsetB=" + offsetB
                + ", offsetW=" + offsetW
                + ", randomR=" + randomR
                + ", randomG=" + randomG
                + ", randomB=" + randomB
                + ", randomW=" + randomW
                + ", randomPointCount=" + randomPointCount
                + ", randomPointOffsetR=" + randomPointOffsetR
                + ", randomPointOffsetG=" + randomPointOffsetG
                + ", randomPointOffsetB=" + randomPointOffsetB
                + ", randomPointOffsetW=" + randomPointOffsetW
                + ", randomPointRandomR=" + randomPointRandomR
                + ", randomPointRandomG=" + randomPointRandomG
                + ", randomPointRandomB=" + randomPointRandomB
                + ", randomPointRandomW=" + randomPointRandomW
                + '}';
    }
}
