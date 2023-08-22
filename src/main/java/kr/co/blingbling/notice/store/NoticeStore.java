package kr.co.blingbling.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.notice.domain.Notice;
import kr.co.blingbling.notice.domain.PageInfo;

public interface NoticeStore {
	/**
	 * 공지사항 세부내역 번호로 조회
	 * @param session
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneByNo(SqlSession session, int noticeNo);
	/**
	 * 공지사항 개수 조회 Store
	 * @param session
	 * @return int
	 */
	public int selectListCount(SqlSession session);
	/**
	 * 공지사항 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return List<Notice>
	 */
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo);
}
