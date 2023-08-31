package kr.co.blingbling.review.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.review.domain.PageInfo;
import kr.co.blingbling.review.domain.Review;
import kr.co.blingbling.review.service.ReviewService;
import kr.co.blingbling.review.store.ReviewStore;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private SqlSession session;
	@Autowired
	private ReviewStore rStore;
	
	@Override
	public int insertReview(Review review) {
		int result = rStore.insertReview(session, review);
		return result;
	}

	@Override
	public int getListCount() {
		int result = rStore.getListCount(session);
		return result;
	}

	@Override
	public List<Review> selectReviewList(PageInfo pInfo) {
		List<Review> rList = rStore.selectReviewList(session, pInfo);
		return rList;
	}

	@Override
	public Review selectOneByNo(int reviewNo) {
		Review review = rStore.selectOneByNo(session, reviewNo);
		return review;
	}
	
}
