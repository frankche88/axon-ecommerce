package pe.edu.unmsm.upg.ecommerce.payment.domain;

import java.math.BigDecimal;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.ecommerce.commands.CreateInvoiceCommand;
import pe.edu.unmsm.upg.ecommerce.events.InvoiceCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

@Aggregate
@SuppressWarnings("unused")
public class InvoiceAggregate {

	@AggregateIdentifier
	private String paymentId;

	private String orderId;

	private BigDecimal totalAmount;

	private User user;

	private List<Product> products;

	private InvoiceStatus invoiceStatus;

	public InvoiceAggregate() {
	}

	@CommandHandler
	public InvoiceAggregate(CreateInvoiceCommand createInvoiceCommand) {
		AggregateLifecycle.apply(new InvoiceCreatedEvent(createInvoiceCommand.paymentId, createInvoiceCommand.orderId,
				createInvoiceCommand.deviceId, createInvoiceCommand.user, createInvoiceCommand.products));
	}

	@EventSourcingHandler
	protected void on(InvoiceCreatedEvent invoiceCreatedEvent) {
		this.paymentId = invoiceCreatedEvent.paymentId;
		this.orderId = invoiceCreatedEvent.orderId;
		this.user = invoiceCreatedEvent.user;
		this.products = invoiceCreatedEvent.products;
		this.totalAmount = invoiceCreatedEvent.totalAmount();
		this.invoiceStatus = InvoiceStatus.PAID;
	}
}
