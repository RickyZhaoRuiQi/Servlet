package servlet;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {

    private String action;  //表示购物车的动作,add,show,delete
    private ItemsDAO idao = new ItemsDAO(); //商品业务逻辑类对象

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/htnl;charset=urf-8");
        if(request.getParameter("action") != null)
        {
            this.action = request.getParameter("action");
            if(action.equals("add"))//添加商品进购物车
            {
                if(addToCart(request,response))
                    request.getRequestDispatcher("/success.jsp").forward(request,response);
                else
                    request.getRequestDispatcher("/failure.jsp").forward(request,response);

            }
            if(action.equals("show"))//如果是显示购物车
            {
                //showCart(request,response);
            }
        }
    }

    //添加商品进购物车的方法
    private boolean addToCart(HttpServletRequest request,HttpServletResponse rensonse)
    {
        String id = request.getParameter("id");
        String number = request.getParameter("num");
        Items item = idao.getItemsById(Integer.parseInt(id));

        //判断是否是第一次给购物车添加商品，需要给session中创建一个新的购物车对象
        if(request.getSession().getAttribute("cart") == null)
        {
            Cart cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }

        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart.addGoodsInCart(item,Integer.parseInt(number)))
            return true;
        else
            return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
