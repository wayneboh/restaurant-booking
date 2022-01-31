

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
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String restaurant = request.getParameter("restaurantName");
		String name = request.getParameter("bookingName");
		String number = request.getParameter("bookingNumber");
		String time = request.getParameter("bookingTime");
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/restaurantBooking", "root", "password");
			 
			 PreparedStatement ps = con.prepareStatement("insert into restaurantbooking values(?,?,?,?)");
			 
			 ps.setString(1, restaurant);
			 ps.setString(2, name);
			 ps.setString(3, number);
			 ps.setString(4, time);
			 
			 int i = ps.executeUpdate();
			 
			if (i > 0){
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "You have successfully reserved a slot!" +
			"</h1>");
			writer.close();
			}
			}
		
		catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
			}
			doGet(request, response);


	}
		
		

}
