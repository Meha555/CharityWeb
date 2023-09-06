package com.huiaicharity.servlet;

import com.huiaicharity.entity.Children;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.service.ChildrenService;
import com.huiaicharity.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showprojectservlet")
public class showProjectServlet extends HttpServlet {
    private ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Projects> projectlist = projectService.showProjects();
        HttpSession session = request.getSession();
        session.setAttribute("projectlist", projectlist);
        response.sendRedirect("showProjects.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

