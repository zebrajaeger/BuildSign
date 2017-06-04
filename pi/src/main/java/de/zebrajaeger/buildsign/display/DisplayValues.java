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
@SuppressWarnings("cyclomaticcomplexity")
public class DisplayValues {

    private static final DisplayValues DEFAULT_VALUES = new DisplayValues(
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

    public void completeWithValues() {
        completeWithValues(DEFAULT_VALUES);
    }

    public void completeWithValues(DisplayValues defaultValues) {
        if (scrollDelay == null) {
            scrollDelay = defaultValues.getScrollDelay();
        }
        if (scrollDirection == null) {
            scrollDirection = defaultValues.getScrollDirection();
        }
        if (percentOfPrevious == null) {
            percentOfPrevious = defaultValues.getPercentOfPrevious();
        }

        if (offsetR == null) {
            offsetR = defaultValues.getOffsetR();
        }
        if (offsetG == null) {
            offsetG = defaultValues.getOffsetG();
        }
        if (offsetB == null) {
            offsetB = defaultValues.getOffsetB();
        }
        if (offsetW == null) {
            offsetW = defaultValues.getOffsetW();
        }
        if (randomR == null) {
            randomR = defaultValues.getRandomR();
        }
        if (randomG == null) {
            randomG = defaultValues.getRandomG();
        }
        if (randomB == null) {
            randomB = defaultValues.getRandomB();
        }
        if (randomW == null) {
            randomW = defaultValues.getRandomW();
        }

        if (randomPointCount == null) {
            randomPointCount = defaultValues.getRandomPointCount();
        }
        if (randomPointOffsetR == null) {
            randomPointOffsetR = defaultValues.getRandomPointOffsetR();
        }
        if (randomPointOffsetG == null) {
            randomPointOffsetG = defaultValues.getRandomPointOffsetG();
        }
        if (randomPointOffsetB == null) {
            randomPointOffsetB = defaultValues.getRandomPointOffsetB();
        }
        if (randomPointOffsetR == null) {
            randomPointOffsetR = defaultValues.getRandomPointOffsetR();
        }
        if (randomPointRandomR == null) {
            randomPointRandomR = defaultValues.getRandomPointRandomR();
        }
        if (randomPointRandomG == null) {
            randomPointRandomG = defaultValues.getRandomPointRandomG();
        }
        if (randomPointRandomB == null) {
            randomPointRandomB = defaultValues.getRandomPointRandomB();
        }
        if (randomPointRandomW == null) {
            randomPointRandomW = defaultValues.getRandomPointRandomW();
        }
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
}
