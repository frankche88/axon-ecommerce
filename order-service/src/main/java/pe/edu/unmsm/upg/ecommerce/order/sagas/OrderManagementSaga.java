package pe.edu.unmsm.upg.ecommerce.order.sagas;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import pe.edu.unmsm.upg.ecommerce.commands.CreateInvoiceCommand;
import pe.edu.unmsm.upg.ecommerce.commands.CreateShippingCommand;
import pe.edu.unmsm.upg.ecommerce.commands.UpdateOrderStatusCommand;
import pe.edu.unmsm.upg.ecommerce.events.InvoiceCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.events.OrderCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.events.OrderShippedEvent;
import pe.edu.unmsm.upg.ecommerce.events.OrderUpdatedEvent;
import pe.edu.unmsm.upg.ecommerce.order.application.message.firebase.PushNotificationRequest;
import pe.edu.unmsm.upg.ecommerce.order.domain.OrderStatus;
import pe.edu.unmsm.upg.ecommerce.order.services.PushNotificationService;

@Saga
public class OrderManagementSaga {

	@Inject
	private transient CommandGateway commandGateway;
	@Inject
	private PushNotificationService notificationService;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		String paymentId = UUID.randomUUID().toString();
		System.out.println("Saga invoked");

		// associate Saga
		SagaLifecycle.associateWith("paymentId", paymentId);

		System.out.println("order id" + orderCreatedEvent.orderId);

		// send the commands
		commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId, orderCreatedEvent.deviceId, orderCreatedEvent.user,
				orderCreatedEvent.products));
	}

	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
		String shippingId = UUID.randomUUID().toString();

		System.out.println("Saga continued");

		// associate Saga with shipping
		SagaLifecycle.associateWith("shipping", shippingId);

		// send the create shipping command
		commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId,
				invoiceCreatedEvent.paymentId, invoiceCreatedEvent.deviceId, invoiceCreatedEvent.user, invoiceCreatedEvent.products));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderShippedEvent orderShippedEvent) {
		commandGateway
				.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, orderShippedEvent.deviceId, String.valueOf(OrderStatus.SHIPPED)));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderUpdatedEvent orderUpdatedEvent) {
		SagaLifecycle.end();
		
		try {
		PushNotificationRequest request = new PushNotificationRequest();
		
		request.setToken(orderUpdatedEvent.deviceId);
		request.setTitle("Notification");
		request.setMessage("You have a new notification");
		
		notificationService.sendPushNotificationToToken(request);
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}
