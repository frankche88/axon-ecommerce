package pe.edu.unmsm.upg.ecommerce.order.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, String> {
	OrderView findOneByOrderId(String orderId);
}