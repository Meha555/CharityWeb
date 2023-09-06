package com.huiaicharity.servlet;

import com.huiaicharity.service.ActivityService;
import com.huiaicharity.service.RewardService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/editactivityservlet")
public class editActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int actid = Integer.parseInt(request.getParameter("actid"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        // 2.调用函数
        int msg = activityService.editActivity(actid,name,address,start_time,end_time);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showactivityservlet").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
