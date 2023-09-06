package com.huiaicharity.servlet;

import com.huiaicharity.entity.News;
import com.huiaicharity.service.NewsService;
import com.huiaicharity.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delnewsservlet")
public class delNewsServlet extends HttpServlet {
    private NewsService newsService = new NewsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        int nid = Integer.parseInt(request.getParameter("nid"));
        // 2.调用函数
        int msg = newsService.deleteNews(nid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("shownewsservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
