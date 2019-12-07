package pe.edu.unmsm.upg.ecommerce.order.services;

import java.util.concurrent.CompletableFuture;

import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);

}
