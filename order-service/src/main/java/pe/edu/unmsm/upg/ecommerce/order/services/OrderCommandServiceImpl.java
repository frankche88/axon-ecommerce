package pe.edu.unmsm.upg.ecommerce.order.services;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO;
import pe.edu.unmsm.upg.ecommerce.order.application.mapper.OrderCreateDtoToOrderCreateCommandMap;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO) {
    	
    	OrderCreateDtoToOrderCreateCommandMap orderCreateCommandMapper = new OrderCreateDtoToOrderCreateCommandMap();
    	
        return commandGateway.send(orderCreateCommandMapper.map(orderCreateDTO));
    }
}
