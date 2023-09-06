package com.huiaicharity.servlet;

import com.huiaicharity.entity.Rewards;
import com.huiaicharity.service.RewardService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/rewardinfoservlet")
public class showRewardInfoServlet extends HttpServlet {
    private RewardService rewardService = new RewardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Rewards> rewardlist = rewardService.getAll();
        request.setAttribute("rewardlist", rewardlist);
        request.getRequestDispatcher("rewardsList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}