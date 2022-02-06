

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantcreateServlet
 */
public class RestaurantcreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantcreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: retrieve the four parameters from the request from the web form
		String name = request.getParameter("name");
		String cuisine = request.getParameter("cuisine");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdetails", "root", "password");
			//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			 PreparedStatement ps = con.prepareStatement("insert into RESTAURANTDETAILS values(?,?,?,?)");
			//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
			 ps.setString(1, name);
			 ps.setString(2, cuisine);
			 ps.setString(3, address);
			 ps.setString(4, info);
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			//Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
			 if (i > 0){
				 PrintWriter writer = response.getWriter();
				 writer.println("<h1>" + "You have successfully added a restaurant!" +
				 "</h1>");
				 writer.println("<h2>"+"<a href=\"http://localhost:8090/restaurantBooking/RestaurantServlet/dashboard\"> Click here to go to restaurant management dashboard </a>"+"</h2>");
				 writer.println("<h2>"+"<a href=\"http://localhost:8090/restaurantBooking/restaurantcreate.jsp\"> Click here to add another restaurant </a>"+"</h2>");
				 writer.println("<h2>"+"<a href=\"http://localhost:8090/restaurantBooking/restauranthome.jsp\"> Click here to return to landing page </a>"+"</h2>");
				 writer.close();
				 }
				 }
		//Step 8: catch and print out any exception
		catch (Exception exception) {
		 System.out.println(exception);
		 out.close();
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
