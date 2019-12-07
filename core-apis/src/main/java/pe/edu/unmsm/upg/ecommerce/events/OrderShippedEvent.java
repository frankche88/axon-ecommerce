package pe.edu.unmsm.upg.ecommerce.events;

import java.util.List;

import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

public class OrderShippedEvent {

	public final String shippingId;

	public final String orderId;

	public final String paymentId;

	public final String deviceId;

	public final User user;

	public final List<Product> products;

	public OrderShippedEvent(String shippingId, String orderId, String paymentId, String deviceId, User user,
			List<Product> products) {
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.deviceId = deviceId;
		this.user = user;
		this.products = products;
	}
}
