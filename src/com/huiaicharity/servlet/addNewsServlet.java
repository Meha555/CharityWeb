package com.huiaicharity.servlet;

import com.huiaicharity.entity.Administrators;
import com.huiaicharity.service.NewsService;
import com.huiaicharity.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addnewsservlet")
public class addNewsServlet extends HttpServlet {
    private NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        String media=request.getParameter("media");
        Administrators admin=(Administrators) session.getAttribute("admin");
        String aid=admin.getAid();
        // 2.调用函数
        int msg = newsService.sendNews(title,content,author,aid,media);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("shownewsservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
