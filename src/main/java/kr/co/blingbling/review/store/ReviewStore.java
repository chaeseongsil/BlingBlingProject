package kr.co.blingbling.review.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.review.domain.PageInfo;
import kr.co.blingbling.review.domain.Review;

public interface ReviewStore {
	/**
	 * 리뷰 등록 Store
	 * @param session
	 * @param review
	 * @return int
	 */
	public int insertReview(SqlSession session, Review review);
	/**
	 * 전체 리뷰 갯수 조회 Store
	 * @param session
	 * @return int
	 */
	public int getListCount(SqlSession session);
	/**
	 * 전체 리뷰 조회 Store
	 * @param session
	 * @param pInfo
	 * @return List<Review>
	 */
	public List<Review> selectReviewList(SqlSession session, PageInfo pInfo);
	/**
	 * 리뷰 상세 조회 Store
	 * @param session
	 * @param reviewNo
	 * @return Review
	 */
	public Review selectOneByNo(SqlSession session, int reviewNo);

}
