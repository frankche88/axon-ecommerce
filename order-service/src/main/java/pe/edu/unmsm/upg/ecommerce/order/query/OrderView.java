package pe.edu.unmsm.upg.ecommerce.order.query;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderView {
	@Id
	@Column(length=36)
    private String orderId;
	private BigDecimal price;
	private String userName;
	private String orderStatus;;
	
	public OrderView() {
	}

	public OrderView(String orderId, BigDecimal price, String userName, String orderStatus) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.userName = userName;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}