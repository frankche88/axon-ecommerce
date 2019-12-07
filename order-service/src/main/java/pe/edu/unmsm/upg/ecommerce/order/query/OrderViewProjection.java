package pe.edu.unmsm.upg.ecommerce.order.query;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.ecommerce.events.OrderCreatedEvent;
import pe.edu.unmsm.upg.ecommerce.events.OrderUpdatedEvent;
import pe.edu.unmsm.upg.ecommerce.order.domain.OrderStatus;

@Component
public class OrderViewProjection {
	private final OrderViewRepository orderViewRepository;
	
	public OrderViewProjection(OrderViewRepository orderViewRepository) {
        this.orderViewRepository = orderViewRepository;
    }
	
	@EventHandler
    public void on(OrderCreatedEvent event, @Timestamp Instant timestamp) {
		OrderView orderView = new OrderView(event.orderId, event.price, event.user.getUsername(), OrderStatus.CREATED.toString());
		orderViewRepository.save(orderView);
    }
	
	@EventHandler
    public void on(OrderUpdatedEvent event, @Timestamp Instant timestamp) {
		OrderView orderView = orderViewRepository.findOneByOrderId(event.orderId);
		orderView.setOrderStatus(event.orderStatus);
		orderViewRepository.save(orderView);
    }
}