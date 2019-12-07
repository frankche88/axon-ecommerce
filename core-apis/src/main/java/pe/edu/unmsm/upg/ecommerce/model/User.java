package pe.edu.unmsm.upg.ecommerce.model;

public class User {
	
	private String id;
	private String username;
	private String email;
	private String cart_id;
	private String customer_id;
	
	
	

	public User(String id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}



	public String getId() {
		return id;
	}

	

	public String getUsername() {
		return username;
	}

	

	public String getEmail() {
		return email;
	}

	
	public String getCart_id() {
		return cart_id;
	}

	

	public String getCustomer_id() {
		return customer_id;
	}

	

}
