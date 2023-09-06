package com.huiaicharity.servlet;

import com.huiaicharity.service.ApplyService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 申请加入志愿者模块
 * APPID自动自增
 * UID和CONTENT从前端获取
 * TIME自动生成
 */
@WebServlet("/addapplyservlet")
public class addApplyServlet extends HttpServlet {
    private ApplyService applyService = new ApplyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uid = request.getParameter("uid");//用户UID
        String content = request.getParameter("content");//申请内容content
        int msg = applyService.insertApplication(uid, content);
        HttpSession session=request.getSession();
        session.setAttribute("msg", msg);
        response.sendRedirect("tijiaoshenqingresult.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
