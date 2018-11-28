package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//继承与HttpServlet
public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理get()请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<strong>Hello Servlet! </strong><br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理post()请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<strong>Hello Servlet!</strong><br>");
    }
}
