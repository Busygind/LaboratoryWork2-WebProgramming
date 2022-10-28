package busygind.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller-servlet", value = "/controller-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET") && parametersAreExists(request)) {
            //UUID senderUUID = UUID.randomUUID();
            //request.getServletContext().setAttribute("sender-id", senderUUID);
            //request.setAttribute("controller-id", senderUUID);
            request.getRequestDispatcher("/area-check-servlet").forward(request, response);
        } else if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            request.getRequestDispatcher("/hits-upload-servlet").forward(request, response);
        }

    }

    private boolean parametersAreExists(HttpServletRequest request) {
        return request.getParameter("x-value") != null
                && request.getParameter("y-value") != null
                && request.getParameter("r-value") != null
                && request.getParameter("timezone") != null;
    }
}
