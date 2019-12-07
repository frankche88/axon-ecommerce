package pe.edu.unmsm.upg.ecommerce.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateOrderStatusCommand {

    @TargetAggregateIdentifier
    public final String orderId;

	public final String deviceId;

    public final String orderStatus;

    public UpdateOrderStatusCommand(String orderId, String deviceId, String orderStatus) {
        this.orderId = orderId;
		this.deviceId = deviceId;
        this.orderStatus = orderStatus;
    }
}
