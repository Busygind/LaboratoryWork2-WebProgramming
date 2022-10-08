package busygind.handlers;

public class Validator {

    private final float x;
    private final float y;
    private final float r;

    public Validator(String x, String y, String r) throws NumberFormatException {
        this.x = Float.parseFloat(x);
        this.y = Float.parseFloat(y);
        this.r = Float.parseFloat(r);
    }

    public boolean dataIsValid() {
        return xIsValid() && yIsValid() && rIsValid();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    private boolean xIsValid() {
        return x >= -2 && x <= 2;
    }

    private boolean yIsValid() {
        return y > -3 && y < 5;
    }

    private boolean rIsValid() {
        return r >= 1 && r <= 3;
    }
}
