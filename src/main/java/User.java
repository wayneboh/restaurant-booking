public class User {
	public User(String restaurantname, String username, String comment) {
		super();
		this.restaurantname = restaurantname;
		this.username = username;
		this.comment = comment;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	protected String restaurantname;
	protected String username;
	protected String comment;
	
	
	
}