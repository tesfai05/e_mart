package edu.miu.e_mart.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;

	@NotEmpty(message = "{validate.notEmpty}")
	private String cardType;

	@CreditCardNumber
	@Size(min = 16, max = 16, message = "Card should have 16 numbers!")
	private String cartNumber;

	@NotEmpty(message = "{validate.notEmpty}")
	private String nameOnCard;

	@NotNull(message = "{validate.notNull}")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date cardExpireDate;
	@NotNull(message = "{validate.notNull}")
	private Integer cvv;

	private LocalDate paymentDate = LocalDate.now();

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public Payment() {
	}

	public Payment(String cartNumber, String nameOnCard, Date cardExpireDate) {
		this.cartNumber = cartNumber;
		this.nameOnCard = nameOnCard;
		this.setCardExpireDate(cardExpireDate);
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(String cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getCardExpireDate() {
		return cardExpireDate;
	}

	public void setCardExpireDate(Date cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	

}