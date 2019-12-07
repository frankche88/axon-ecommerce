package pe.edu.unmsm.upg.ecommerce.order.application.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import pe.edu.unmsm.upg.ecommerce.commands.CreateOrderCommand;
import pe.edu.unmsm.upg.ecommerce.model.Product;
import pe.edu.unmsm.upg.ecommerce.model.User;
import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO;
import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO.ProductDto;
import pe.edu.unmsm.upg.ecommerce.order.application.dto.OrderCreateDTO.UserDto;
import pe.edu.unmsm.upg.ecommerce.order.domain.OrderStatus;

public class OrderCreateDtoToOrderCreateCommandMap {

	public CreateOrderCommand map(OrderCreateDTO orderCreateDTO) {
		
		if(orderCreateDTO.getId() == null) {
			String orderId = UUID.randomUUID().toString();
			orderCreateDTO.setId(orderId);
		}

		return new CreateOrderCommand(orderCreateDTO.getId(), orderCreateDTO.getDeviceId(), orderCreateDTO.getAmount(),
				orderCreateDTO.getCreatedAt(), map(orderCreateDTO.getUser()), map(orderCreateDTO.getProducts()),
				String.valueOf(OrderStatus.CREATED));

	}

	public User map(UserDto userDto) {

		if (userDto == null) {
			return null;
		}

		return new User(userDto.getId(), userDto.getUsername(), userDto.getEmail());

	}

	public Product map(ProductDto productDto) {

		if (productDto == null) {
			return null;
		}

		return new Product(productDto.getId(), productDto.getDescription(), productDto.getPrice());

	}

	public List<Product> map(List<ProductDto> productsDto) {

		if (productsDto == null || productsDto.size() == 0) {
			return null;
		}

		return productsDto.stream().map(this::map).collect(Collectors.toCollection(ArrayList::new));

	}

}
