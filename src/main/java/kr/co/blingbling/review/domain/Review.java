package kr.co.blingbling.review.domain;

import java.sql.Timestamp;

import kr.co.blingbling.product.domain.Product;

public class Review {

	private int reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private String reviewWriter;
	private int productNo;
	private String reviewStar;
	private String reviewFilename;
	private String reviewFileRename;
	private String reviewFilepath;
	private long reviewFileLength;
	private int reviewCount;
	private Timestamp rCreateDate;
	private Timestamp rUpdateDate;
	private String rStatus;
	private Product product;
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewFilename() {
		return reviewFilename;
	}
	public void setReviewFilename(String reviewFilename) {
		this.reviewFilename = reviewFilename;
	}
	public String getReviewFileRename() {
		return reviewFileRename;
	}
	public void setReviewFileRename(String reviewFileRename) {
		this.reviewFileRename = reviewFileRename;
	}
	public String getReviewFilepath() {
		return reviewFilepath;
	}
	public void setReviewFilepath(String reviewFilepath) {
		this.reviewFilepath = reviewFilepath;
	}
	public long getReviewFileLength() {
		return reviewFileLength;
	}
	public void setReviewFileLength(long reviewFileLength) {
		this.reviewFileLength = reviewFileLength;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public Timestamp getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Timestamp rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Timestamp getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Timestamp rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "후기 [글번호=" + reviewNo + ", 제목=" + reviewTitle + ", 내용=" + reviewContent
				+ ", 작성자=" + reviewWriter + ", 상품번호=" + productNo + ", 별점=" + reviewStar
				+ ", 파일이름=" + reviewFilename + ", 파일리네임=" + reviewFileRename + ", 파일경로="
				+ reviewFilepath + ", 파일크기=" + reviewFileLength + ", 조회수=" + reviewCount
				+ ", 작성일=" + rCreateDate + ", 수정일=" + rUpdateDate + ", 사용여부=" + rStatus + "]";
	}
	
	
}
