import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(email, password))
        {
            try{  
          	  
                response.setContentType("text/html");  
                PrintWriter value = response.getWriter();  
         
                String n=request.getParameter("email");  
                value.print("Welcome "+n);  
              
                Cookie ck=new Cookie("email",n);//creating cookie object  
                response.addCookie(ck);//adding cookie in the response  
            	response.sendRedirect("http://localhost:8090/restaurantBooking/UserServlet/dashboard");
                value.close();}
            catch(Exception e){
            	System.out.println(e);
            	}  
            //RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            //rs.forward(request, response);
            
        
              }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}
