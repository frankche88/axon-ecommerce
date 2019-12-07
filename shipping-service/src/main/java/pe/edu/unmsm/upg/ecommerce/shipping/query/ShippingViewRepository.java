package pe.edu.unmsm.upg.ecommerce.shipping.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingViewRepository extends JpaRepository<ShippingView, String> {
	ShippingView findOneByShippingId(String shippingId);
}