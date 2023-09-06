package com.huiaicharity.servlet;
import com.huiaicharity.entity.Children;
import com.huiaicharity.service.ChildrenService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showchildservlet")
public class showChildServlet extends HttpServlet {
    private ChildrenService childrenService = new ChildrenService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArrayList<Children> childrenlist = childrenService.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("childrenlist", childrenlist);
        response.sendRedirect("showChildren.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

