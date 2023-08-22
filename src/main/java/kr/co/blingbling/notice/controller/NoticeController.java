package kr.co.blingbling.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blingbling.notice.domain.Notice;
import kr.co.blingbling.notice.domain.PageInfo;
import kr.co.blingbling.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="/board/noticeList.do", method=RequestMethod.GET)
	public String showNoticeList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		int totalCount = service.getListCount();
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> nList = service.selectNoticeList(pInfo);
		model.addAttribute("nList", nList);
		model.addAttribute("pInfo", pInfo);
		return "notice/notice";
	}
	
	@RequestMapping(value="/board/noticeDetail.do", method=RequestMethod.GET)
	public String showDetailNotice(
			@RequestParam("noticeNo") int noticeNo
			, Model model
			) {
		Notice notice = service.selectOneByNo(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/noticeView";
	}
	
	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount = (int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage + 0.9))-1)*naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, naviTotalCount, startNavi, endNavi, totalCount);
		return pi;
	}
}
