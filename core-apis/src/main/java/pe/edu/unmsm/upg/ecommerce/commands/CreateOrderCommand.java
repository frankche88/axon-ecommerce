package pe.edu.unmsm.upg.ecommerce.commands;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

public class CreateOrderCommand {

	@TargetAggregateIdentifier
	public final String orderId;

	public final String deviceId;

	public final User user;

	public final List<Product> products;

	public final BigDecimal amount;

	public final Date createdAt;

	public final String orderStatus;

	public CreateOrderCommand(String orderId, String deviceId, BigDecimal amount, 
			Date createdAt, User user,
			List<Product> products, String orderStatus) {
		this.orderId = orderId;
		this.amount = amount;
		this.createdAt = createdAt;
		this.user = user;
		this.products = products;
		this.deviceId = deviceId;
		this.orderStatus = orderStatus;
	}

}
