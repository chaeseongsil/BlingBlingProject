package kr.co.blingbling.qna.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.qna.domain.PageInfo;
import kr.co.blingbling.qna.domain.Qna;
import kr.co.blingbling.qna.store.QnaStore;

@Repository
public class QnaStoreLogic implements QnaStore{

	@Override
	public int insertQna(SqlSession session, Qna qna) {
		int result = session.insert("QnaMapper.insertQna", qna);
		return result;
	}

	@Override
	public int updateQna(SqlSession session, Qna qna) {
		int result = session.update("QnaMapper.updateQna", qna);
		return result;
	}

	@Override
	public int deleteQna(SqlSession session, int myQnaNo) {
		int result = session.delete("QnaMapper.deleteQna", myQnaNo);
		return result;
	}

	@Override
	public Qna selectOneByNo(SqlSession session, int myQnaNo) {
		Qna qna = session.selectOne("QnaMapper.selectOneByNo", myQnaNo);
		return qna;
	}

	@Override
	public int selectAllListCount(SqlSession session) {
		int result = session.selectOne("QnaMapper.selectAllListCount");
		return result;
	}

	@Override
	public List<Qna> selectAllQnaList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int currentPage = pInfo.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Qna> qList = session.selectList("QnaMapper.selectAllQnaList", null, rowBounds);
		return qList;
	}

	@Override
	public int selectMyListCount(SqlSession session, String myQnaWriter) {
		int result = session.selectOne("QnaMapper.selectMyListCount", myQnaWriter);
		return result;
	}

	@Override
	public List<Qna> selectMyQnaList(SqlSession session, PageInfo pInfo, String myQnaWriter) {
		int limit = pInfo.getRecordCountPerPage();
		int currentPage = pInfo.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Qna> qList = session.selectList("QnaMapper.selectMyQnaList", myQnaWriter, rowBounds);
		return qList;
	}

//	@Override
//	public String generateAllPageNavi(SqlSession session, int currentPage) {
//		int totalCount = selectCountAllQna(session);
//		int recordCountPerPage = 5;
//		int naviTotalCount = 0;
//		if(totalCount % recordCountPerPage > 0) {
//			naviTotalCount = totalCount / recordCountPerPage + 1;
//		}else {
//			naviTotalCount = totalCount / recordCountPerPage;
//		}
//		int naviCountPerPage = 5;
//		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage + 1;
//		int endNavi = startNavi + naviCountPerPage - 1;
//		if(endNavi > naviTotalCount) {
//			endNavi = naviTotalCount;
//		}
//		boolean needPrev = (startNavi == 1) ? false : true;
//		boolean needNext = (endNavi == naviTotalCount) ? false : true;
//		StringBuilder result = new StringBuilder();
//		if(needPrev) {
//			result.append("<a href='/qna/list.do?currentPage="+(startNavi-1)+"'>"
//					+ "<button class=\"prev-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/271/271220.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		for(int i = startNavi; i <= endNavi; i++) {
//			result.append("<a href='/qna/list.do?currentPage="+i+"'>"+i+"&nbsp;&nbsp;</a>");
//		}
//		if(needNext) {
//			result.append("<a href='/qna/list.do?currentPage="+(endNavi+1)+"'><button class=\"next-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/87/87425.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		return result.toString();
//	}
//
//	@Override
//	public String generateMyPageNavi(SqlSession session, int currentPage, String myQnaWriter) {
//		int totalCount = selectCountMyQna(session, myQnaWriter);
//		int recordCountPerPage = 5;
//		int naviTotalCount = 0;
//		if(totalCount % recordCountPerPage > 0) {
//			naviTotalCount = totalCount / recordCountPerPage + 1;
//		}else {
//			naviTotalCount = totalCount / recordCountPerPage;
//		}
//		int naviCountPerPage = 5;
//		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage + 1;
//		int endNavi = startNavi + naviCountPerPage - 1;
//		if(endNavi > naviTotalCount) {
//			endNavi = naviTotalCount;
//		}
//		boolean needPrev = (startNavi == 1) ? false : true;
//		boolean needNext = (endNavi == naviTotalCount) ? false : true;
//		StringBuilder result = new StringBuilder();
//		if(needPrev) {
//			result.append("<a href='/myQna/list.do?memberId="+myQnaWriter+"&currentPage="+(startNavi-1)+"'>"
//					+ "<button class=\"prev-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/271/271220.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		for(int i = startNavi; i <= endNavi; i++) {
//			result.append("<a href='/myQna/list.do?memberId="+myQnaWriter+"&currentPage="+i+"'>"+i+"&nbsp;&nbsp;</a>");
//		}
//		if(needNext) {
//			result.append("<a href='/myQna/list.do?memberId="+myQnaWriter+"&currentPage="+(endNavi+1)+"'><button class=\"next-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/87/87425.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		return result.toString();
//	}

}
