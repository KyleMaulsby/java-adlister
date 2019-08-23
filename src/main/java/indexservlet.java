import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="indexservlet", urlPatterns="/")
public class indexservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        session.setAttribute("isLoggedIn", "false");
//        session.setAttribute("user", "");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
