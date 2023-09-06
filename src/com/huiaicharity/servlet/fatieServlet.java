package com.huiaicharity.servlet;

import com.huiaicharity.entity.BBS;
import com.huiaicharity.service.BBSService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 发帖和展示帖子模块【类似百度贴吧的样式】
 */
@WebServlet("/fatieservlet")
public class fatieServlet extends HttpServlet {
    private BBSService bbsService = new BBSService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        int msg = bbsService.sendTiezi(title, author, content);
        ArrayList<BBS> bbslist = bbsService.getAll();
        request.setAttribute("msg", msg);
        request.setAttribute("bbslist", bbslist);
        request.getRequestDispatcher("forum.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
