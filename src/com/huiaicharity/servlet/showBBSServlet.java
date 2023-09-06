package com.huiaicharity.servlet;

import com.huiaicharity.entity.BBS;
import com.huiaicharity.entity.Children;
import com.huiaicharity.service.BBSService;
import com.huiaicharity.service.ChildrenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showbbsservlet")
public class showBBSServlet extends HttpServlet {
    private BBSService bbsService = new BBSService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<BBS> bbslist = bbsService.getAll();
        //HttpSession session = request.getSession();
        //session.setAttribute("bbslist", bbslist);
        //response.sendRedirect("forum.jsp");
        request.setAttribute("bbslist", bbslist);
        request.getRequestDispatcher("forum.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

