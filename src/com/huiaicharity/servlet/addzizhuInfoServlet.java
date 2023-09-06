package com.huiaicharity.servlet;

import com.huiaicharity.service.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addzizhuinfoservlet")
public class addzizhuInfoServlet extends HttpServlet {
    private UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.接收参数
        String cid = request.getParameter("cid");
        String uid = request.getParameter("uid");
        int num = Integer.parseInt(request.getParameter("num"));
        String type = request.getParameter("type");
        // 2.调用函数
        int msg = usersService.zizhu(cid, uid, num, type);
        // 3.返回参数
        HttpSession session=request.getSession();
        session.setAttribute("msg", msg);
        response.sendRedirect("zizhuresult.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
