package com.huiaicharity.servlet;

import com.huiaicharity.entity.Children;
import com.huiaicharity.service.ChildrenService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/showchildinfoservlet")
public class showChildInfoServlet extends HttpServlet {
    private ChildrenService childrenService = new ChildrenService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Children> childrenlist = childrenService.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("childrenlist", childrenlist);
        response.sendRedirect("zizhulist.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

