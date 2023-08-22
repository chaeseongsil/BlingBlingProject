package kr.co.blingbling.cart.domain;

public class Cart {
	private int cartNo;
	private String memberId;
	private int productNo;
	private String productColor;
	private String pImagePath;
	private int amount;
	private int cartPrice;
	
	public Cart() {}
	
	public Cart(String memberId, int productNo, String productColor, String pImagePath, int amount, int cartPrice) {
		super();
		this.memberId = memberId;
		this.productNo = productNo;
		this.productColor = productColor;
		this.pImagePath = pImagePath;
		this.amount = amount;
		this.cartPrice = cartPrice;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getpImagePath() {
		return pImagePath;
	}

	public void setpImagePath(String pImagePath) {
		this.pImagePath = pImagePath;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	@Override
	public String toString() {
		return "장바구니 [장바구니번호=" + cartNo + ", 회원ID=" + memberId + ", 상품번호=" + productNo + ", 상품색상="
				+ productColor + ", 상품수량=" + amount + ", 상품가격=" + cartPrice + "]";
	}
	
	
}
