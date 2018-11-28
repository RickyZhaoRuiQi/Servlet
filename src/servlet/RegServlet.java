package servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Users u = new Users();
        String username,mypassword,gender,email,introduce,isAccept;
        Date birthday;
        String[] favorite;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            username = request.getParameter("username");
            mypassword = request.getParameter("mypassword");
            gender = request.getParameter("gender");
            email = request.getParameter("email");
            introduce = request.getParameter("introduce");
            birthday = sdf.parse(request.getParameter("birthday"));
            if(request.getParameter("flag") != null)
            {
                isAccept = request.getParameter("isAccept");
            }
            else
            {
                isAccept = "false";
            }
            //用来获取多个复选按钮的值
            favorite = request.getParameterValues("favorite");

            u.setUsername(username);
            u.setMypassword(mypassword);
            u.setGender(gender);
            u.setEmail(email);
            u.setFavorites(favorite);
            u.setFlag(isAccept.equals("true")?true:false);
            u.setBirthday(birthday);
            u.setIntroduce(introduce);

            //把注册成功的用户对象保存在session中
            if(isAccept.equals("true"))
                u.setFlag(true);
            else
                u.setFlag(false);
            //跳转到注册成功页面
            request.getSession().setAttribute("regUser",u);
            request.getRequestDispatcher("../userinfo.jsp").forward(request,response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
