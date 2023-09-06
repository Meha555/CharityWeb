package com.huiaicharity.servlet;

import com.huiaicharity.service.RewardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/editrewardservlet")
public class editRewardServlet extends HttpServlet {
    private RewardService rewardService=new RewardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int cost=Integer.parseInt(request.getParameter("cost"));
        int rid=Integer.parseInt(request.getParameter("rid"));
        int sum=Integer.parseInt(request.getParameter("sum"));
        String name=request.getParameter("name");
        int msg=rewardService.editRewards(rid,name,cost,sum);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showrewardservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
