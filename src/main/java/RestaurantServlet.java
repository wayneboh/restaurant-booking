
import java.io.IOException;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantServlet
 */
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/restaurantdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
		// database
		private static final String INSERT_RESTAURANT_SQL = "INSERT INTO RestaurantDetails"
				+ " (name, cuisine, address, info) VALUES " + " (?, ?, ?);";
		private static final String SELECT_RESTAURANT_BY_ID = "select name, cuisine, address, info from RestaurantDetails where name =?";
		private static final String SELECT_ALL_RESTAURANTS = "select * from RestaurantDetails ";
		private static final String DELETE_RESTAURANTS_SQL = "delete from RestaurantDetails where name = ?;";
		private static final String UPDATE_RESTAURANTS_SQL = "update RestaurantDetails set name = ?,cuisine= ?, address =?,info =? where name = ?;";
		
		// Step 3: Implement the getConnection method which facilitates connection to
		// the database via JDBC
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/RestaurantServlet/delete":
				deleteRestaurant(request, response);
				break;
			case "/RestaurantServlet/edit":
				showEditForm(request, response);
				break;
			case "/RestaurantServlet/update":
				updateRestaurant(request, response);
				break;
			case "/RestaurantServlet/dashboard":
				listRestaurants(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	// Step 5: listRestaurants function to connect to the database and retrieve all restaurants
	// records
	private void listRestaurants(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Restaurant> restaurants = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESTAURANTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String cuisine = rs.getString("cuisine");
				String address = rs.getString("address");
				String info = rs.getString("info");
				restaurants.add(new Restaurant(name, cuisine, address, info));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the restaurants list into the listRestaurants attribute to be pass to
				// the restaurantManagement.jsp
				request.setAttribute("listRestaurants", restaurants);
				request.getRequestDispatcher("/restaurantManagement.jsp").forward(request, response);
	}
	
	// method to get parameter, query database for existing restaurant data and redirect
	// to restaurant edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String name = request.getParameter("name");
		Restaurant existingRestaurant = new Restaurant("", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT_BY_ID);) {
			preparedStatement.setString(1, name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				name = rs.getString("name");
				String cuisine = rs.getString("cuisine");
				String address = rs.getString("address");
				String info = rs.getString("info");
				existingRestaurant = new Restaurant(name, cuisine, address, info);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingRestaurant to request and serve up the restaurantEdit form
		request.setAttribute("restaurant", existingRestaurant);
		request.getRequestDispatcher("/RestaurantEdit.jsp").forward(request, response);
	}
	// method to update the restaurant table base on the form data
	private void updateRestaurant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String cuisine = request.getParameter("cuisine");
		String address = request.getParameter("address");
		String info = request.getParameter("info");

		// Step 2: Attempt connection with database and execute update restaurant SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RESTAURANTS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, cuisine);
			statement.setString(3, address);
			statement.setString(4, info);
			statement.setString(5, oriName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to RestaurantServlet (note: remember to change the url to
		// your project name)
		response.sendRedirect("http://localhost:8090/restaurantBooking/RestaurantServlet/dashboard");
	}
	
	// method to delete restaurant
	private void deleteRestaurant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String name = request.getParameter("name");
		// Step 2: Attempt connection with database and execute delete restaurant SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_RESTAURANTS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to RestauratServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/restaurantBooking/RestaurantServlet/dashboard");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
