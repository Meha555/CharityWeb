package com.huiaicharity.servlet;

import com.huiaicharity.entity.Rewards;
import com.huiaicharity.service.RewardService;
import com.huiaicharity.service.VolunteerService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * 兑换模块
 */
@WebServlet("/exchangeservlet")
public class ExchangeServlet extends HttpServlet {
    private VolunteerService volunteerService = new VolunteerService();
    private RewardService rewardService=new RewardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String vid = request.getParameter("vid");//志愿者ID
        int rid = Integer.parseInt(request.getParameter("rid"));//奖品ID
        int num = Integer.parseInt(request.getParameter("num"));//兑换数量
        int msg = volunteerService.exchangeReward(vid, rid, num);
        HttpSession session=request.getSession();
        session.setAttribute("msg", num);
        response.sendRedirect("exchangeresult.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
