package com.huiaicharity.servlet;

import com.huiaicharity.entity.vo.MsgModel;
import com.huiaicharity.service.LoginService;
import com.huiaicharity.service.RegisterService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/loginregister")//用注解了，不去web.xml中写了
public class LogRegServlet extends HttpServlet{//Controller层
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        String group=request.getParameter("group");
        String flag=request.getParameter("subbtn");
        System.out.println("flag="+flag);
        MsgModel mm=new MsgModel();
        if(flag.equals("Login")){//登录
            LoginService ls=new LoginService();
            if(group.equals("user"))
                mm=ls.userLogin(id,pwd);//设置执行service后的响应对象
            else if(group.equals("admin"))
                mm=ls.adminLogin(id,pwd);//设置执行service后的响应对象
            if(mm.isCode()){//状态码true
                HttpSession session=request.getSession();//这里用session，用户信息需要全程显示
                if(group.equals("user")){
                    session.setAttribute("user",mm.getObject());//传值后有自动类型转换
                    response.sendRedirect("personal_center.html");//是去首页，登录页不需要了，使用重定向
                }
                else if(group.equals("admin")){
                    session.setAttribute("admin",mm.getObject());//传值后有自动类型转换
                    response.sendRedirect("admin_center.html");//是去首页，登录页不需要了，使用重定向
                }
            }
            else {//状态码false
                HttpSession session=request.getSession();
                session.setAttribute("mm",mm);
                request.getRequestDispatcher("loginregister.html").forward(request,response);//回到登录页，使用转发
            }
            System.out.println(group+" "+id+" "+pwd);
        }
        else{//注册
            RegisterService rs=new RegisterService();
            String tell=id;
            HttpSession session=request.getSession();//这里用session，用户信息需要全程显示
            if(group.equals("user")){
                mm=rs.userReg(tell,pwd);//对于注册来说是tell和pwd
                session.setAttribute("user",mm.getObject());//传值后有自动类型转换
            }
            else if(group.equals("admin")){
                mm=rs.adminReg(tell,pwd);//对于注册来说是tell和pwd
                session.setAttribute("admin",mm.getObject());//传值后有自动类型转换
            }
            response.sendRedirect("personal_center.html");//是去首页，登录页不需要了，使用重定向
        }
        System.out.println(mm.getMsg());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
