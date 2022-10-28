package busygind.entities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class DataTransferObject {

    private Hit hit;
    private List<Hit> hits;
    private int actionCounter;

    public DataTransferObject() {
        this.hit = null;
        this.hits = null;
        this.actionCounter = 0;
    }

    public void setHit(Hit hit) {
        this.hit = hit;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public void setActionCounter(int actionCounter) {
        this.actionCounter = actionCounter;
    }

    public Hit getHit() {
        return hit;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public int getActionCounter() {
        return actionCounter;
    }

    public String toJSONString() throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }
}
