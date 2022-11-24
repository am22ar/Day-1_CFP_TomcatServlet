import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login page testing",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "user" , value = "Amar"),
                @WebInitParam(name = "password" , value = "Amar")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //data from html form
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        if(userID.equals(user) && password.equals(pwd))
        {
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color:red> Either UserName or Password is incorrect</font>");
            rd.include(request,response);
        }


    }
}
