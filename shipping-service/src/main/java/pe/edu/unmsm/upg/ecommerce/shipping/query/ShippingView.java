package pe.edu.unmsm.upg.ecommerce.shipping.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShippingView {
	@Id
	@Column(length=36)
    private String shippingId;
    private String orderId;
	private String userName;
	private String products;;
	
	public ShippingView() {
	}

	public ShippingView(String shippingId, String orderId, String userName, String products) {
		super();
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.userName = userName;
		this.products = products;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	

	
}