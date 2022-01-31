import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageBookingServlet
 */
public class ManageBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/restaurantbooking";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	 private static final String INSERT_BOOKING_SQL = "INSERT INTO restaurantbooking" + " (restaurantName, bookingName, bookingNumber, bookingTime) VALUES " + " (?, ?, ?);";
			  private static final String SELECT_BOOKING_BY_ID = "select restaurantName,bookingName,bookingNumber,bookingTime from restaurantbooking where bookingName =?";
			  private static final String SELECT_ALL_BOOKING = "select * from restaurantBooking ";
			  private static final String DELETE_BOOKINGS_SQL = "delete from restaurantbooking where bookingName = ?;";
			  private static final String UPDATE_BOOKINGS_SQL = "update restaurantbooking set restaurantName = ?,bookingName= ?, bookingNumber =?, where bookingTime = ?;";
			  
			  
			  protected Connection getConnection() {
				  Connection connection = null;
				  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				  } catch (SQLException e) {
				  e.printStackTrace();
				  } catch (ClassNotFoundException e) {
				  e.printStackTrace();
				  }
				  return connection;
				  }	  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/ManageBookingServlet/delete":
			 deleteBooking(request, response);
			 break;
			 case "/ManageBookingServlet/edit":
			 showBookingForm(request, response);
			 break;
			 case "/ManageBookingServlet/update":
			 updateBooking(request, response);
			 break;
		 default:
		 listBookings(request, response);
		 break;
		 }
		 
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void listBookings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List <Booking> bookings = new ArrayList <>();
			 try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING);) {
			 
			 ResultSet rs = preparedStatement.executeQuery();
			 
			 while (rs.next()) {
			 String restaurantName = rs.getString("restaurantName");
			 String bookingName = rs.getString("bookingName");
			 String bookingNumber = rs.getString("bookingNumber");
			 String bookingTime = rs.getString("bookingTime");
			 bookings.add(new Booking(restaurantName, bookingName, bookingNumber, bookingTime));
			 }
			 } catch (SQLException e) {
			 System.out.println(e.getMessage());
			 }
			
			request.setAttribute("listBookings", bookings);
			request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
			}
	
	private void showBookingForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
			String bookingName = request.getParameter("bookingName");
			Booking existingBooking = new Booking("", "", "", "");
			
			try (Connection connection = getConnection();
			
			PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
			preparedStatement.setString(1, bookingName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
			bookingName = rs.getString("bookingName");
			String restaurantName = rs.getString("restaurantName");
			String bookingNumber = rs.getString("bookingNumber");
			String bookingTime = rs.getString("bookingTime");
			existingBooking = new Booking(restaurantName, bookingName, bookingNumber, bookingTime);
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			request.setAttribute("booking", existingBooking);
			request.getRequestDispatcher("/bookingEdit.jsp").forward(request, response);
			}
	
	private void updateBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			
			 String restaurantName = request.getParameter("restaurantName");
			 String bookingName = request.getParameter("bookingName");
			 String bookingNumber = request.getParameter("bookingNumber");
			 String bookingTime = request.getParameter("bookingTime");

			 //Step 2: Attempt connection with database and execute update user SQL query
			 try (Connection connection = getConnection(); PreparedStatement statement =
			connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
			 statement.setString(1, restaurantName);
			 statement.setString(2, bookingName);
			 statement.setString(3, bookingNumber);
			 statement.setString(4, bookingTime);
			 int i = statement.executeUpdate();
			 }
			 response.sendRedirect("http://localhost:8090/restaurant-booking/ManageBookingServlet");
			}
	
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			
			 String bookingName = request.getParameter("bookingName");
			 //Step 2: Attempt connection with database and execute delete user SQL query
			 try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
			 statement.setString(1, bookingName);
			 int i = statement.executeUpdate();
			 }
			 
			 response.sendRedirect("http://localhost:8090/restaurant-booking/ManageBookingServlet");
			}

}
