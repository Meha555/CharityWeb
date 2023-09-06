package com.huiaicharity.servlet;

import com.huiaicharity.entity.Applications;
import com.huiaicharity.entity.Rewards;
import com.huiaicharity.service.ApplyService;
import com.huiaicharity.service.RewardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showapplicationservlet")
public class showApplicationServlet extends HttpServlet {
    private ApplyService applyService = new ApplyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Applications> applicationslist = applyService.getAll();
        request.setAttribute("applicationslist", applicationslist);
        request.getRequestDispatcher("showApplications.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

