package kr.co.blingbling.review.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.review.domain.PageInfo;
import kr.co.blingbling.review.domain.Review;
import kr.co.blingbling.review.store.ReviewStore;

@Repository
public class ReviewStoreLogic implements ReviewStore{

	@Override
	public int insertReview(SqlSession session, Review review) {
		int result = session.insert("ReviewMapper.insertReview", review);
		return result;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("ReviewMapper.getListCount");
		return result;
	}

	@Override
	public List<Review> selectReviewList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int currentPage = pInfo.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Review> rList = session.selectList("ReviewMapper.selectReviewList", null, rowBounds);
		return rList;
	}

	@Override
	public Review selectOneByNo(SqlSession session, int reviewNo) {
		Review review = session.selectOne("ReviewMapper.selectOneByNo", reviewNo);
		return review;
	}

}
