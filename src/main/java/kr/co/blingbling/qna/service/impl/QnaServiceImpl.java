package kr.co.blingbling.qna.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.qna.domain.PageInfo;
import kr.co.blingbling.qna.domain.Qna;
import kr.co.blingbling.qna.service.QnaService;
import kr.co.blingbling.qna.store.QnaStore;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	private QnaStore qStore;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertQna(Qna qna) {
		int result = qStore.insertQna(sqlSession, qna);
		return result;
	}

	@Override
	public int updateQna(Qna qna) {
		int result = qStore.updateQna(sqlSession, qna);
		return result;
	}

	@Override
	public int deleteQna(int myQnaNo) {
		int result = qStore.deleteQna(sqlSession, myQnaNo);
		return result;
	}

	@Override
	public Qna selectOneByNo(int myQnaNo) {
		Qna qna = qStore.selectOneByNo(sqlSession, myQnaNo);
		return qna;
	}

	@Override
	public int getAllListCount() {
		int result = qStore.selectAllListCount(sqlSession);
		return result;
	}

	@Override
	public List<Qna> selectAllQnaList(PageInfo pInfo) {
		List<Qna> qList = qStore.selectAllQnaList(sqlSession, pInfo);
		return qList;
	}

	@Override
	public int getMyListCount(String myQnaWriter) {
		int result = qStore.selectMyListCount(sqlSession, myQnaWriter);
		return result;
	}

	@Override
	public List<Qna> selectMyQnaList(PageInfo pInfo, String myQnaWriter) {
		List<Qna> qList = qStore.selectMyQnaList(sqlSession, pInfo, myQnaWriter);
		return qList;
	}


}
