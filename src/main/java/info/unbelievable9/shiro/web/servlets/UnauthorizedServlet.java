package info.unbelievable9.shiro.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on : 2018/7/27
 * Author     : Unbelievable9
 **/
@WebServlet(name = "unauthorizedServlet", urlPatterns = "/unauthorized")
public class UnauthorizedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/unauthorized.jsp").forward(req, resp);
    }
}
