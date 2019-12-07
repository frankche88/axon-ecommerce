package pe.edu.unmsm.upg.ecommerce.model;

import java.math.BigDecimal;

public class Product {
	
	private String id;
	private String description;
	private BigDecimal price;
	
	
	
	
	public Product(String id, String description, BigDecimal price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}



	public String getId() {
		return id;
	}

	

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}



	@Override
	public String toString() {
		return "{\"id\": \"" + id + "\", \"description\":\"" + description + "\", \"price\":" + price + "}";
	}
	
	
	
	


}
