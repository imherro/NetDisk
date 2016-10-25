package cat.code.netdisk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zinc on 2016/10/23.
 *
 * @author Image
 */
@WebServlet(name = "Panle" , urlPatterns = "/Panel")
public class Panel extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        IsLogin il=new IsLogin();
        int login=il.isLogin(session,request,response);
        if(login==1){
            new List().setList(session);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Panel.jsp");
            dispatcher.forward(request, response);
        }else{
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.getWriter().write(" <script type=\"text/javascript\" >alert(\"请先登陆\");</script>\n");
        }
    }
}
