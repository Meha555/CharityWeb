package com.huiaicharity.servlet;
import com.huiaicharity.service.UsersService;
import com.huiaicharity.entity.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
@WebServlet("/showpersonalinfoservlet")
public class showPersonalInfoServlet extends HttpServlet {
    private UsersService usersService=new UsersService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        Users user= (Users) session.getAttribute("user");
        user=usersService.selectUserByUID(user.getUid());
        session.setAttribute("user",user);
        request.getRequestDispatcher("showPersonalInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
