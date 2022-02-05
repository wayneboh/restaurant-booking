
public class Booking {
	
	protected String restaurantName;
	 protected String bookingName;
	 protected String bookingNumber;
	 protected String bookingTime;
	 
	 
	public Booking(String restaurantName, String bookingName, String bookingNumber, String bookingTime) {
		super();
		this.restaurantName = restaurantName;
		this.bookingName = bookingName;
		this.bookingNumber = bookingNumber;
		this.bookingTime = bookingTime;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getBookingName() {
		return bookingName;
	}
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	public String getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

}
