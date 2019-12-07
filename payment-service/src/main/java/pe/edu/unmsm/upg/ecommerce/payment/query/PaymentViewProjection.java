package pe.edu.unmsm.upg.ecommerce.payment.query;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.ecommerce.events.InvoiceCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.payment.domain.InvoiceStatus;

@Component
public class PaymentViewProjection {
	private final PaymentViewRepository paymentViewRepository;
	
	public PaymentViewProjection(PaymentViewRepository paymentViewRepository) {
        this.paymentViewRepository = paymentViewRepository;
    }
	
	@EventHandler
    public void on(InvoiceCreatedEvent event, @Timestamp Instant timestamp) {
		PaymentView paymentView = new PaymentView(event.paymentId, event.orderId, event.totalAmount(), event.user.getUsername(),event.products.toString(),  InvoiceStatus.PAID.toString());
		paymentViewRepository.save(paymentView);
    }
	
}