package pe.edu.unmsm.upg.ecommerce.payment.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentViewRepository extends JpaRepository<PaymentView, String> {
	PaymentView findOneByPaymentId(String paymentId);
}