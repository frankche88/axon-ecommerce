package pe.edu.unmsm.upg.ecommerce.commands;

import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

public class CreateShippingCommand {

    @TargetAggregateIdentifier
    public final String shippingId;

    public final String orderId;

    public final String paymentId;

	public final String deviceId;

	public final User user;

	public final List<Product> products;

    public CreateShippingCommand(String shippingId, String orderId, String paymentId, String deviceId, User user, List<Product> products) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.paymentId = paymentId;
		this.deviceId = deviceId;
        this.user = user;
        this.products = products;
    }
}
