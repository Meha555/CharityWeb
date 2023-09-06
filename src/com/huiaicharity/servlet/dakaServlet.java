package com.huiaicharity.servlet;

import com.huiaicharity.service.VolunteerService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 打卡模块
 * 志愿者活动结束后点击打卡，更新VID\HOURS\
 */
@WebServlet("/dakaservlet")
public class dakaServlet extends HttpServlet {
    private VolunteerService volunteerService = new VolunteerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String vid = request.getParameter("vid");//志愿者id
        int hours = Integer.parseInt(request.getParameter("hours"));//志愿时长
        int msg = volunteerService.ClockIn(vid, hours);
        HttpSession session=request.getSession();
        session.setAttribute("msg",msg);
        response.sendRedirect("dakaresult.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
