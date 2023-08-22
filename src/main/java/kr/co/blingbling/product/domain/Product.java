package kr.co.blingbling.product.domain;

import java.sql.Timestamp;

public class Product {
	private int productNo;
	private String productName;
	private int productPrice;
	private String productCategory;
	private String pImageName;
	private String pImagePath;
	private String pImageLength;
	private Timestamp pRegDate;
	private String pStockYn;
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getpImageName() {
		return pImageName;
	}
	public void setpImageName(String pImageName) {
		this.pImageName = pImageName;
	}
	public String getpImagePath() {
		return pImagePath;
	}
	public void setpImagePath(String pImagePath) {
		this.pImagePath = pImagePath;
	}
	public String getpImageLength() {
		return pImageLength;
	}
	public void setpImageLength(String pImageLength) {
		this.pImageLength = pImageLength;
	}
	public Timestamp getpRegDate() {
		return pRegDate;
	}
	public void setpRegDate(Timestamp pRegDate) {
		this.pRegDate = pRegDate;
	}
	public String getpStockYn() {
		return pStockYn;
	}
	public void setpStockYn(String pStockYn) {
		this.pStockYn = pStockYn;
	}
	@Override
	public String toString() {
		return "상품 [상품번호=" + productNo + ", 상품명=" + productName + ", 상품가격=" + productPrice
				+ ", 카테고리=" + productCategory + ", 상품이미지이름=" + pImageName + ", 상품이미지경로=" 
				+ pImagePath + ", 상품이미지크기=" + pImageLength + ", 상품등록일=" + pRegDate + ", 주문가능여부=" + pStockYn + "]";
	}
	
}
