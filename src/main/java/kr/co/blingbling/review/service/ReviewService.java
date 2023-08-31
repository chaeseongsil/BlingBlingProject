package kr.co.blingbling.review.service;

import java.util.List;

import kr.co.blingbling.review.domain.PageInfo;
import kr.co.blingbling.review.domain.Review;

public interface ReviewService {
	/**
	 * 리뷰 등록 Service
	 * @param review
	 * @return int
	 */
	public int insertReview(Review review);
	/**
	 * 전체 리뷰 갯수 Service
	 * @return int
	 */
	public int getListCount();
	/**
	 * 전체 리뷰 조회 Service
	 * @param pInfo
	 * @return List<Review>
	 */
	public List<Review> selectReviewList(PageInfo pInfo);
	/**
	 * 리뷰 상세 조회 Service
	 * @param reviewNo
	 * @return Review
	 */
	public Review selectOneByNo(int reviewNo);

}
