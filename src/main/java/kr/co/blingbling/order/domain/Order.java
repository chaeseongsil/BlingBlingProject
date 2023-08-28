package kr.co.blingbling.order.domain;

import java.sql.Timestamp;

public class Order {
	private String orderNo;
	private String memberId;
	private String productNo;
	private String orderName;
	private String memberName;
	private String memberPostCode;
	private String memberAddr1;
	private String memberAddr2;
	private String memberPhone;
	private String memberEmail;
	private Timestamp orderDate;
	private String payment;
	private int orderPrice;
	private String orderStatus;
	
	public Order() {}
	
	public Order(String orderNo, String memberId, String productNo, String orderName, String memberName,
			String memberPostCode, String memberAddr1, String memberAddr2, String memberPhone, String memberEmail,
			String payment, int orderPrice) {
		super();
		this.orderNo = orderNo;
		this.memberId = memberId;
		this.productNo = productNo;
		this.orderName = orderName;
		this.memberName = memberName;
		this.memberPostCode = memberPostCode;
		this.memberAddr1 = memberAddr1;
		this.memberAddr2 = memberAddr2;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.payment = payment;
		this.orderPrice = orderPrice;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPostCode() {
		return memberPostCode;
	}
	public void setMemberPostCode(String memberPostCode) {
		this.memberPostCode = memberPostCode;
	}
	public String getMemberAddr1() {
		return memberAddr1;
	}
	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "주문내역 [주문번호=" + orderNo + ", 아이디=" + memberId + ", 상품번호=" + productNo + ", 상품이름="
				+ orderName + ", 주문자이름=" + memberName + ", 우편번호=" + memberPostCode + ", 기본주소="
				+ memberAddr1 + ", 상세주소=" + memberAddr2 + ", 연락처=" + memberPhone + ", 이메일="
				+ memberEmail + ", 주문일자=" + orderDate + ", 결제수단=" + payment + ", 주문금액=" + orderPrice
				+ ", 주문상태=" + orderStatus + "]";
	}
	
}
