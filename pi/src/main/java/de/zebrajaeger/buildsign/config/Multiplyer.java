package de.zebrajaeger.buildsign.config;

/**
 * @author Lars Brandt
 */
public class Multiplyer {
    public static final Multiplyer DEFAULT_MULTIPLYER = new Multiplyer(1.0, 1.0, 1.0, 1.0);

    private Double r;
    private Double g;
    private Double b;
    private Double w;

    public Multiplyer() {
    }

    public Multiplyer(Double r, Double g, Double b, Double w) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.w = w;
    }

    public Multiplyer fillWith(Multiplyer toFillWith) {
        Multiplyer result = new Multiplyer();
        result.r = (r != null) ? r : toFillWith.r;
        result.g = (g != null) ? g : toFillWith.g;
        result.b = (b != null) ? b : toFillWith.b;
        result.w = (w != null) ? w : toFillWith.w;
        return result;
    }

    public Multiplyer overwriteWith(Multiplyer toOverwriteWith) {
        Multiplyer result = new Multiplyer();
        result.r = (toOverwriteWith.r != null) ? toOverwriteWith.r : r;
        result.g = (toOverwriteWith.g != null) ? toOverwriteWith.g : g;
        result.b = (toOverwriteWith.b != null) ? toOverwriteWith.b : b;
        result.w = (toOverwriteWith.w != null) ? toOverwriteWith.w : w;
        return result;
    }

    public Double getR() {
        return r;
    }

    public Double getG() {
        return g;
    }

    public Double getB() {
        return b;
    }

    public Double getW() {
        return w;
    }

    public Integer multiplyR(Integer value) {
        return multiply(value, r);
    }

    public Integer multiplyG(Integer value) {
        return multiply(value, g);
    }

    public Integer multiplyB(Integer value) {
        return multiply(value, b);
    }

    public Integer multiplyW(Integer value) {
        return multiply(value, w);
    }

    private Integer multiply(Integer value, Double multiplyWith) {
        Integer result = value;
        if (value != null && multiplyWith != null) {
            result = (int) (multiplyWith * result);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Multiplyer{" + "r=" + r + ", g=" + g + ", b=" + b + ", w=" + w + '}';
    }
}
