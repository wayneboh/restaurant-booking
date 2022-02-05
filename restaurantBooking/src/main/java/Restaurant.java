
public class Restaurant {
	protected String name;
	 
	 public Restaurant(String name, String cuisine, String address, String info) {
		 super();
		 this.name = name;
		 this.cuisine = cuisine;
		 this.address = address;
		 this.info = info;
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	 protected String cuisine;
	 protected String address;
	 protected String info;

}

