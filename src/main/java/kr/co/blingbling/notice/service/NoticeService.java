package kr.co.blingbling.notice.service;

import java.util.List;

import kr.co.blingbling.notice.domain.Notice;
import kr.co.blingbling.notice.domain.PageInfo;

public interface NoticeService {
	/**
	 * 공지사항 번호로 조회 Service
	 * @param noticeNo
	 * @return
	 */
	public Notice selectOneByNo(int noticeNo);
	/**
	 * 공지사항 전체 개수 조회 Service
	 * @return
	 */
	public int getListCount();
	/**
	 * 공지사항 목록 조회 Service
	 * @param pInfo
	 * @return List<Notice>
	 */
	public List<Notice> selectNoticeList(PageInfo pInfo);

}
