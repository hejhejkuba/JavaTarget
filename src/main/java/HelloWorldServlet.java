import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String message = "Hello World";

        // wypisanie wartości parametru "abc" przy użyciu filtru
        if (fname == null) {
            System.out.println(fname);
            // wypisanie "Hello World"
            response.setContentType("text/html");
            response.getWriter().println("<h1>" + message + "</h1>");
        }
        else{
            System.out.println(fname);
            // wypisanie "Hello World"
            response.setContentType("text/html");
            response.getWriter().println("<h1>Hello " + fname + "</h1>");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        doGet(request, response);
    }

}




