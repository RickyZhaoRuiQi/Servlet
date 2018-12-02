package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetInitParameterServlet")
public class GetInitParameterServlet extends HttpServlet {

    private String uesrname;
    private String password;

    public String getUesrname() {
        return uesrname;
    }

    public void setUesrname(String uesrname) {
        this.uesrname = uesrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("   <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("   <BODY>");
        out.println("   <h2>用户名："+this.getUesrname()+"</h2>");
        out.println("   <h2>密码："+this.getPassword()+"</h2>");
        out.println("   </BODY>");
        out.println("<HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void init() throws ServletException {
        this.setUesrname(this.getInitParameter("username"));
        this.setPassword(this.getInitParameter("password"));
    }
}
