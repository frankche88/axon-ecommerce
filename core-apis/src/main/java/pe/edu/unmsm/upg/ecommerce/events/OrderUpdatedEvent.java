package pe.edu.unmsm.upg.ecommerce.events;

public class OrderUpdatedEvent {

    public final String orderId;

    public final String deviceId;

    public final String orderStatus;

    public OrderUpdatedEvent(String orderId, String deviceId, String orderStatus) {
        this.orderId = orderId;
		this.deviceId = deviceId;
        this.orderStatus = orderStatus;
    }
}
