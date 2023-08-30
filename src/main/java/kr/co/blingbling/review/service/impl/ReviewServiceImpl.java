package kr.co.blingbling.review.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.review.service.ReviewService;
import kr.co.blingbling.review.store.ReviewStore;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private SqlSession session;
	@Autowired
	private ReviewStore rStore;
	
}
