package com.huiaicharity.servlet;

import com.huiaicharity.entity.Administrators;
import com.huiaicharity.service.AdminService;
import com.huiaicharity.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/denyapplyservlet")
public class denyApplyServlet extends HttpServlet {
    private AdminService adminService = new AdminService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        int appid = Integer.parseInt(request.getParameter("appid"));
        // 2.调用函数
        int msg = adminService.denyApplication(appid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showapplicationservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
