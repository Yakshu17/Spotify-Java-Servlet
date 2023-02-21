import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Check extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(email, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Main.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Email or Password Incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("Login.html");
           rs.include(request, response);
        }
    }  
}