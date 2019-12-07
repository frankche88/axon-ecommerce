package pe.edu.unmsm.upg.ecommerce.order.api;

import io.swagger.annotations.Api;
import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO;
import pe.edu.unmsm.upg.ecommerce.order.services.OrderCommandService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {

    private OrderCommandService orderCommandService;

    public OrderCommandController(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        return orderCommandService.createOrder(orderCreateDTO);
    }
}
