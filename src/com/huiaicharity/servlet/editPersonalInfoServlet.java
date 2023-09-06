package com.huiaicharity.servlet;

import com.huiaicharity.entity.Users;
import com.huiaicharity.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editpersonalinfoservlet")
public class editPersonalInfoServlet extends HttpServlet {
    private UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        Users user= (Users) session.getAttribute("user");
        String uid=request.getParameter("uid");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        int age=Integer.parseInt(request.getParameter("age"));
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String tell=request.getParameter("tell");
        String password=request.getParameter("password");
        String identity=request.getParameter("identity");
        String is_volunteer=request.getParameter("is_volunteer");
        user.setAll(uid,name,sex,age,email,address,is_volunteer,tell,password,identity);
        int msg=usersService.updateUserInfo(user);
        session.setAttribute("user",user);
        response.sendRedirect("showPersonalInfo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}