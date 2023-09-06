package com.huiaicharity.servlet;
import com.huiaicharity.service.ChildrenService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addchildservlet")
public class addChildServlet extends HttpServlet {
    private ChildrenService childrenService = new ChildrenService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("cid");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String region = request.getParameter("region");
        String situation = request.getParameter("situation");
        String after_help = request.getParameter("after_help");
        String tell = request.getParameter("tell");
        String end_time = request.getParameter("end_time");
        String aid = request.getParameter("aid");//管理员AID
        int msg = childrenService.addChildren(cid,name,sex,age,region,situation,after_help,tell,aid);
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showchildservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}