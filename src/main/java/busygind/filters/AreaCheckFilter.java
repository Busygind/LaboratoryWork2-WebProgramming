package busygind.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "area-check-filter", value = "/area-check-servlet")
public class AreaCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        if (request.getDispatcherType().equals(DispatcherType.REQUEST)) {
            PrintWriter writer = res.getWriter();
            writer.println("Direct access to AreaCheckServlet is forbidden!");
            res.setStatus(403);
            writer.close();
            return;
        }
        chain.doFilter(request, response);
    }
}
