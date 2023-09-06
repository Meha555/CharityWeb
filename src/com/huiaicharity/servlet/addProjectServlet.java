package com.huiaicharity.servlet;

import com.huiaicharity.service.ProjectService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addprojectservlet")
public class addProjectServlet extends HttpServlet {
    private ProjectService projectsService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String organizer = request.getParameter("organizer");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String aid = request.getParameter("aid");
        // 2.调用函数
        int msg = projectsService.addProjects(name, organizer, start_time, end_time, aid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showprojectservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
