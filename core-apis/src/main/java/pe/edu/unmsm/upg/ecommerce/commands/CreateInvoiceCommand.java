package pe.edu.unmsm.upg.ecommerce.commands;

import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;

public class CreateInvoiceCommand{

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;

	public final String deviceId;

	public final User user;

	public final List<Product> products;

    public CreateInvoiceCommand(String paymentId, String orderId, String deviceId, User user, List<Product> products) {
        this.paymentId = paymentId;
        this.orderId = orderId;
		this.deviceId = deviceId;
        this.user = user;
        this.products = products;
    }
}
