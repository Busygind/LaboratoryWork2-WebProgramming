package busygind.servlets;

import busygind.handlers.ContextHandler;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "context-servlet", value = "/context-servlet")
public class ContextServlet extends HttpServlet {
    private final ContextHandler contextHandler = new ContextHandler();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        String responseBody = om.writeValueAsString(contextHandler.getDataFromContext(request.getServletContext()));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        printWriter.write(responseBody);
        printWriter.flush();
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        contextHandler.setContextData(request.getServletContext(), new ArrayList<>());
        System.out.println(contextHandler.getDataFromContext(request.getServletContext()));
    }

}