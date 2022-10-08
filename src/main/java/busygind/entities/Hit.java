package busygind.entities;

import java.time.Instant;

public class Hit {

    private float x;
    private float y;
    private float r;
    private boolean result;
    private Instant time;

    public Hit(float x, float y, float r, String timeOffset) {
        this.x = x;
        this.y = y;
        this.r = r;
        long offset = Long.parseLong(timeOffset);
        this.time = Instant.now().minusSeconds(offset * 60L);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
