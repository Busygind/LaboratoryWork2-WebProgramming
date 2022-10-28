package busygind.servlets;

import busygind.entities.DataTransferObject;
import busygind.handlers.ContextHandler;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "hits-upload-servlet", value = "/hits-upload-servlet")
public class HitsUploadServlet extends HttpServlet {
    private final ContextHandler contextHandler = new ContextHandler();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // upload hits from context
        PrintWriter printWriter = response.getWriter();

        ServletContext context = request.getServletContext();
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setHits(contextHandler.getHitsFromContext(request.getServletContext()));
        dataTransferObject.setActionCounter((int) contextHandler.getIntegerAttributeFromContext(context, "count-of-servlets-action"));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        printWriter.write(dataTransferObject.toJSONString());
        printWriter.flush();
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // delete hits from context
        contextHandler.setHitsToContext(request.getServletContext(), new ArrayList<>());
    }

}
