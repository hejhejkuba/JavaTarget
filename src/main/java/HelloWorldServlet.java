import java.io.IOException;
import java.io.Serial;
import java.lang.reflect.Field;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String message = "Hello World";
        Names names = new Names();

        // wypisanie wartości parametru "abc" przy użyciu filtru
        if (fname == null || fname.isEmpty()) {
            //System.out.println(fname);
            // wypisanie "Hello World"
            response.setContentType("text/html");
            response.getWriter().println("<h1>" + message + "</h1>");
        }
        else if(fname.equals("Hal")){
            Field halField = null;
            try {
                halField = Names.class.getDeclaredField("hal");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            MyTarget halAnnotation = halField.getAnnotation(MyTarget.class);
            String halValue = halAnnotation.value();
            RequestDispatcher rd=request.getRequestDispatcher(halValue+".jsp");
            rd.forward(request, response);
        }
        else if(fname.equals("David")){
            Field davidField = null;
            try {
                davidField = Names.class.getDeclaredField("david");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            MyTarget davidAnnotation = davidField.getAnnotation(MyTarget.class);
            String davidValue = davidAnnotation.value();
            // wypisanie "Hello $NAME"
            RequestDispatcher rd=request.getRequestDispatcher(davidValue+".jsp");
            rd.forward(request, response);
        }
        else if(fname.equals("Johny")){
            //System.out.println(fname);
            // wypisanie "Hello $NAME"
            response.sendError(418, "Error");
        }
        else{
            System.out.println(fname);
            // wypisanie "Hello $NAME"
            response.setContentType("text/html");
            response.getWriter().println("<h1>Hello " + fname + "</h1>");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}




