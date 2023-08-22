package kr.co.blingbling.qna.service;

import java.util.List;

import kr.co.blingbling.qna.domain.PageInfo;
import kr.co.blingbling.qna.domain.Qna;

public interface QnaService {
	public int insertQna(Qna qna);

	public int updateQna(Qna qna);
	
	public int deleteQna(int myQnaNo);
	
	public Qna selectOneByNo(int myQnaNo);

	public int getAllListCount();

	public List<Qna> selectAllQnaList(PageInfo pInfo);

	public int getMyListCount(String myQnaWriter);

	public List<Qna> selectMyQnaList(PageInfo pInfo, String myQnaWriter);
}
