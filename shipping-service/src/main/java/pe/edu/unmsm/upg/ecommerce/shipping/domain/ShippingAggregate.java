package pe.edu.unmsm.upg.ecommerce.shipping.domain;

import pe.edu.unmsm.upg.ecommerce.commands.CreateShippingCommand;
import pe.edu.unmsm.upg.ecommerce.events.OrderShippedEvent;
import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@SuppressWarnings("unused")
public class ShippingAggregate {

	@AggregateIdentifier
	private String shippingId;

	private String orderId;

	private String paymentId;

	private User user;

	private List<Product> products;

	public ShippingAggregate() {
	}

	@CommandHandler
	public ShippingAggregate(CreateShippingCommand createShippingCommand) {
		AggregateLifecycle.apply(new OrderShippedEvent(createShippingCommand.shippingId, createShippingCommand.orderId,
				createShippingCommand.paymentId, createShippingCommand.deviceId, createShippingCommand.user, createShippingCommand.products));
	}

	@EventSourcingHandler
	protected void on(OrderShippedEvent orderShippedEvent) {
		this.shippingId = orderShippedEvent.shippingId;
		this.orderId = orderShippedEvent.orderId;
		this.user = orderShippedEvent.user;
		this.products = orderShippedEvent.products;
	}
}
