package pe.edu.unmsm.upg.ecommerce.order.domain;

import java.math.BigDecimal;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.ecommerce.commands.CreateOrderCommand;
import pe.edu.unmsm.upg.ecommerce.commands.UpdateOrderStatusCommand;
import pe.edu.unmsm.upg.ecommerce.events.OrderCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.events.OrderUpdatedEvent;
import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

@Aggregate
@SuppressWarnings("unused")
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;

	private BigDecimal price;
	
	private User user;
	
	private List<Product> products;

	private OrderStatus orderStatus;

	public OrderAggregate() {
	}

	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.deviceId, createOrderCommand.amount,
				createOrderCommand.user, createOrderCommand.products, createOrderCommand.orderStatus));
	}

	@EventSourcingHandler
	protected void on(OrderCreatedEvent orderCreatedEvent) {
		this.orderId = orderCreatedEvent.orderId;
		this.price = orderCreatedEvent.price;
		this.user =  orderCreatedEvent.user;
		this.products =  orderCreatedEvent.products;
		this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
	}

	@CommandHandler
	protected void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
		AggregateLifecycle
				.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, updateOrderStatusCommand.deviceId, updateOrderStatusCommand.orderStatus));
	}

	@EventSourcingHandler
	protected void on(OrderUpdatedEvent orderUpdatedEvent) {
		this.orderId = orderUpdatedEvent.orderId;
		this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
	}
}
