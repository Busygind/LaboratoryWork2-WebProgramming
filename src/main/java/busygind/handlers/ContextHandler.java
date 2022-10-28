package busygind.handlers;

import busygind.entities.Hit;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class ContextHandler {

    public List<Hit> getHitsFromContext(ServletContext context) {
        List<Hit> hits = (List<Hit>) context.getAttribute("hits");
        return hits == null || hits.isEmpty() ? new ArrayList<>() : hits;
    }

    public Object getIntegerAttributeFromContext(ServletContext context, String attrName) {
        return (context.getAttribute(attrName) == null) ? 0 : context.getAttribute(attrName);
    }

    public void setHitsToContext(ServletContext context, List<Hit> hits) {
        context.setAttribute("hits", hits);
    }
}
