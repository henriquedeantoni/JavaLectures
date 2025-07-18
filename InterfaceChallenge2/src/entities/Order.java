package entities;

import java.util.Date;

public class Order {
	private Integer orderCode;
	private Date orderDate;
	private Double orderAmount;
	
	public Order() {
	}

	public Order(Integer orderCode, Date orderDate, Double orderAmount) {
		super();
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}

	public Integer getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "Order [orderCode=" 
				+ orderCode 
				+ ", orderDate=" 
				+ orderDate 
				+ ", orderAmount=" 
				+ orderAmount 
				+ "]";
	}
	
	
}
