package com.huiaicharity.servlet;

import com.huiaicharity.entity.Projects;
import com.huiaicharity.entity.Rewards;
import com.huiaicharity.service.ProjectService;
import com.huiaicharity.service.RewardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showrewardservlet")
public class showRewardServlet extends HttpServlet {
    private RewardService rewardService = new RewardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Rewards> rewardlist = rewardService.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("rewardlist", rewardlist);
        response.sendRedirect("showRewards.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

