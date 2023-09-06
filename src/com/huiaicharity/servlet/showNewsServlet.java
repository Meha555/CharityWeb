package com.huiaicharity.servlet;

import com.huiaicharity.entity.News;
import com.huiaicharity.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/shownewsservlet")
public class showNewsServlet extends HttpServlet {
    private NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArrayList<News> newslist = newsService.getAll();
        request.setAttribute("newslist", newslist);
        request.getRequestDispatcher("NewsList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

