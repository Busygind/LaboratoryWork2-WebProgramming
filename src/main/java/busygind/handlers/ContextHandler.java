package busygind.handlers;

import busygind.entities.Hit;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class ContextHandler {

    public List<Hit> getDataFromContext(ServletContext context) {
        List<Hit> hits = (List<Hit>) context.getAttribute("hits");
        return hits == null || hits.isEmpty() ? new ArrayList<>() : hits;
    }

    public void setContextData(ServletContext context, List<Hit> hits) {
        context.setAttribute("hits", hits);
    }
}
