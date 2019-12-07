package pe.edu.unmsm.upg.ecommerce.events;

import java.math.BigDecimal;
import java.util.List;

import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

public class OrderCreatedEvent {

	public final String orderId;

	public final String deviceId;

	public final BigDecimal price;

	public final User user;

	public final List<Product> products;

	public final String orderStatus;

	public OrderCreatedEvent(String orderId, String deviceId, BigDecimal price, User user, List<Product> products,
			String orderStatus) {
		this.orderId = orderId;
		this.deviceId = deviceId;
		this.price = price;
		this.user = user;
		this.products = products;
		this.orderStatus = orderStatus;
	}
}
