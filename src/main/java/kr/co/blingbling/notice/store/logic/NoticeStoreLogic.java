package kr.co.blingbling.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.notice.domain.Notice;
import kr.co.blingbling.notice.domain.PageInfo;
import kr.co.blingbling.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore{

	@Override
	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	@Override
	public int selectListCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.selectListCount");
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int currentPage = pInfo.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}


//	@Override
//	public String generatePageNavi(SqlSession session, int currentPage) {
//		int totalCount = selectCountNotice(session);
//		int recordCountPerPage = 10;
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
//			result.append("<a href='/board/noticeList.do?currentPage="+(startNavi-1)+"'>"
//					+ "<button class=\"prev-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/271/271220.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		for(int i = startNavi; i <= endNavi; i++) {
//			result.append("<a href='/board/noticeList.do?currentPage="+i+"'>"+i+"&nbsp;&nbsp;</a>");
//		}
//		if(needNext) {
//			result.append("<a href='/board/noticeList.do?currentPage="+(endNavi+1)+"'><button class=\"next-btn\">\r\n"
//					+ "                                <img src=\"https://cdn-icons-png.flaticon.com/512/87/87425.png\" alt=\"\">\r\n"
//					+ "                            </button></a>");
//		}
//		return result.toString();
//	}

}
