/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
  
public class database extends HttpServlet {  

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
try(PrintWriter out = response.getWriter()) {  
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","chander@1234");
        
        PreparedStatement ps=con.prepareStatement("insert into tb1 values(?,?)");
        
        ps.setString(1,email);
        ps.setString(2,password);
        
        int i=ps.executeUpdate();
        if(i>0)
            out.print("You are successfully registered...");
           RequestDispatcher rs = request.getRequestDispatcher("Login.html");
           rs.include(request, response);
        
          
    }
    catch(ClassNotFoundException | SQLException e2)
    {
        System.out.println(e2);
    }
}
}
}
      
           
  
 