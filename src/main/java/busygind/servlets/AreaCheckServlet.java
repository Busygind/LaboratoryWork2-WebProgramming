package busygind.servlets;

import busygind.entities.Hit;
import busygind.handlers.ContextHandler;
import busygind.handlers.Validator;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "area-check-servlet", value = "/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        ContextHandler contextHandler = new ContextHandler();
        List<Hit> hits = contextHandler.getDataFromContext(context);

        ObjectMapper om = new ObjectMapper();

        PrintWriter pw = response.getWriter();
        if (request.getAttribute("controller-id") != null &&
                context.getAttribute("sender-id") != null &&
                request.getAttribute("controller-id").equals(context.getAttribute("sender-id"))) {

            try {
                Validator validator = new Validator(request.getParameter("x-value"), request.getParameter("y-value"),
                        request.getParameter("r-value"));
                Hit hit = new Hit(validator.getX(), validator.getY(), validator.getR(), request.getParameter("timezone"));
                hit.setResult(checkHit(hit));

                hits.add(hit);
                contextHandler.setContextData(context, hits);

                String responseBody = om.writeValueAsString(hit);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                pw.write(responseBody);
                pw.flush();
            } catch (NumberFormatException ignored) {

            }
        } else {
            // request sender isn't controller
            pw.write("Incorrect sender!");
            pw.flush();
        }
    }

    private boolean checkHit(Hit hit) {
        float x = hit.getX();
        float y = hit.getY();
        float r = hit.getR();
        boolean inCircle = (x * x + y * y <= r * r) && x >= 0 && y >= 0;
        boolean inRect = x >= -r / 2 && y <= r && x <= 0 && y >= 0;
        boolean inTriangle = y >= -x - r && x <= 0 && y <= 0;
        return inCircle || inRect || inTriangle;
    }
}
