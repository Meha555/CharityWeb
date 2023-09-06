package com.huiaicharity.servlet;

import com.huiaicharity.service.RewardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 新增活动servlet
 * ACTID自动自增
 * <p>
 * TIME自动生成
 */
@WebServlet("/addrewardservlet")
public class addRewardServlet extends HttpServlet {
    private RewardService rewardService = new RewardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int cost = Integer.parseInt(request.getParameter("cost"));
        int num = Integer.parseInt(request.getParameter("num"));
        int msg = rewardService.addRewards(name,cost,num);
        HttpSession session=request.getSession();
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showrewardservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}