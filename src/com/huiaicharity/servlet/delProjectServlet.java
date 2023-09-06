package com.huiaicharity.servlet;

import com.huiaicharity.service.ActivityService;
import com.huiaicharity.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delprojectservlet")
public class delProjectServlet extends HttpServlet {
    private ProjectService projectService = new ProjectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        int pid = Integer.parseInt(request.getParameter("pid"));
        // 2.调用函数
        int msg = projectService.deleteProjects(pid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showprojectservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
