package com.huiaicharity.servlet;

import com.huiaicharity.service.ActivityService;
import com.huiaicharity.service.ProjectService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delactivityservlet")
public class delActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        int actid = Integer.parseInt(request.getParameter("actid"));
        // 2.调用函数
        int msg = activityService.deleteActivities(actid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showactivityservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
