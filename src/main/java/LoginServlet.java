import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isLoggedIn = (String) request.getSession().getAttribute("isLoggedIn");
        System.out.println(isLoggedIn);
        if (isLoggedIn == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            response.sendRedirect("/profile");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = (username.equals("admin") && password.equals("p"));

        if (validAttempt) {
            request.getSession().setAttribute("isLoggedIn","true");
            request.getSession().setAttribute("user",username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }

    }
}
