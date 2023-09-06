package com.huiaicharity.servlet;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.service.ActivityService;
import com.huiaicharity.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showactivityservlet")
public class showActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArrayList<Activities> activitylist = activityService.showActivity();
        HttpSession session = request.getSession();
        session.setAttribute("activitylist", activitylist);
        response.sendRedirect("showActivities.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

