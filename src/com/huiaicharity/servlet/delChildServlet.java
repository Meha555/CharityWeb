package com.huiaicharity.servlet;
import com.huiaicharity.service.ChildrenService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delchildservlet")
public class delChildServlet extends HttpServlet {
    private ChildrenService childrenService = new ChildrenService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收参数
        String cid = request.getParameter("cid");
        // 2.调用函数
        int msg = childrenService.deleteChild(cid);
        // 3.返回参数
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("showchildservlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
