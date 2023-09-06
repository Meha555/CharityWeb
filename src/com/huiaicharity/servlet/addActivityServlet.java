package com.huiaicharity.servlet;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.service.ActivityService;
import com.huiaicharity.service.AdminService;
import com.huiaicharity.service.NewsService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 新增活动servlet
 * ACTID自动自增
 * <p>
 * TIME自动生成
 */
@WebServlet("/addactivityservlet")
public class addActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");//内容content
        String address = request.getParameter("address");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String aid = request.getParameter("aid");//管理员AID
        int msg = activityService.addActivities(name, address, start_time, end_time, aid);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showactivityservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}