package pe.edu.unmsm.upg.ecommerce.payment.query;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentView {
	@Id
	@Column(length=36)
    private String paymentId;
	private String orderId;
	private BigDecimal totalAmount;
	private String userName;
	private String products;
	private String invoiceStatus;;
	
	public PaymentView() {
	}

	

	public PaymentView(String paymentId, String orderId, BigDecimal totalAmount, String userName, String products,
			String invoiceStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.userName = userName;
		this.products = products;
		this.invoiceStatus = invoiceStatus;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public BigDecimal getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getProducts() {
		return products;
	}



	public void setProducts(String products) {
		this.products = products;
	}



	public String getInvoiceStatus() {
		return invoiceStatus;
	}



	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	
}