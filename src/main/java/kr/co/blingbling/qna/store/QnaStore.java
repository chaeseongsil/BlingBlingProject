package kr.co.blingbling.qna.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.qna.domain.PageInfo;
import kr.co.blingbling.qna.domain.Qna;

public interface QnaStore {
	
	public int insertQna(SqlSession session, Qna qna);
	
	public int updateQna(SqlSession session, Qna qna);
	
	public int deleteQna(SqlSession session, int myQnaNo);

	public Qna selectOneByNo(SqlSession session, int myQnaNo);
	
	public int selectAllListCount(SqlSession session);

	public List<Qna> selectAllQnaList(SqlSession session, PageInfo pInfo);

	public int selectMyListCount(SqlSession session, String myQnaWriter);

	public List<Qna> selectMyQnaList(SqlSession session, PageInfo pInfo, String myQnaWriter);

}
