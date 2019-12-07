package pe.edu.unmsm.upg.ecommerce.shipping.query;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.ecommerce.events.OrderShippedEvent;

@Component
public class ShippingViewProjection {
	private final ShippingViewRepository shippingViewRepository;

	public ShippingViewProjection(ShippingViewRepository shippingViewRepository) {
		this.shippingViewRepository = shippingViewRepository;
	}

	@EventHandler
	public void on(OrderShippedEvent event, @Timestamp Instant timestamp) {
		ShippingView shippingView = new ShippingView(event.shippingId, event.orderId, event.user.getUsername(),
				event.products.toString());
		shippingViewRepository.save(shippingView);
	}
}