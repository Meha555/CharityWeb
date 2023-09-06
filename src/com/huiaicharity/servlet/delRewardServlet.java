package com.huiaicharity.servlet;

import com.huiaicharity.service.RewardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delrewardservlet")
public class delRewardServlet extends HttpServlet {
    private RewardService rewardService = new RewardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        int rid=Integer.parseInt(request.getParameter("rid"));
        // 2.调用函数
        int msg = rewardService.deleteRewards(rid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showrewardservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
