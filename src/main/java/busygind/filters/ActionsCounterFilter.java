package busygind.filters;

import busygind.handlers.ContextHandler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "actions-counter-filter", value = "/*", description = "counter for all servlets usages")
public class ActionsCounterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        ContextHandler contextHandler = new ContextHandler();
        int count = (int) contextHandler.getIntegerAttributeFromContext(context, "count-of-servlets-action");
        count++;
        System.out.println(count);
        context.setAttribute("count-of-servlets-action", count);
        chain.doFilter(request, response);
    }
}
