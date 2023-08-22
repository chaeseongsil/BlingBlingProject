package kr.co.blingbling.qna.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.blingbling.qna.domain.PageInfo;
import kr.co.blingbling.qna.domain.Qna;
import kr.co.blingbling.qna.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	private QnaService service;
	
	@RequestMapping(value="/qna/write.do", method=RequestMethod.GET)
	public String showAllQnaWriteView() {
		return "qna/allQnaWrite";
	}
	
	@RequestMapping(value="/qna/write.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String insertInAllQnaPage(
			@RequestParam("qnaList") String myQnaTitle
			, @RequestParam("content") String myQnaContent
			, @RequestParam("writer") String myQnaWriter
			, @RequestParam("password") String myQnaPw
			, Model model
			) {
		Qna qna = new Qna(myQnaTitle, myQnaContent, myQnaWriter, myQnaPw);
		int result = service.insertQna(qna);
		if(result > 0) {
			return "<script>alert('문의가 등록되었습니다.'); location.href='/qna/list.do';</script>";
		}else {
			return "<script>alert('문의 등록을 실패하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/myQna/write.do", method=RequestMethod.GET)
	public String showMyQnaWriteView() {
		return "qna/myQnaWrite";
	}
	
	@RequestMapping(value="/myQna/write.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String insertInMyQnaPage(
			@RequestParam("qnaList") String myQnaTitle
			, @RequestParam("content") String myQnaContent
			, @RequestParam("writer") String myQnaWriter
			, @RequestParam("password") String myQnaPw
			, Model model
			) {
		Qna qna = new Qna(myQnaTitle, myQnaContent, myQnaWriter, myQnaPw);
		int result = service.insertQna(qna);
		if(result > 0) {
			return "<script>alert('문의가 등록되었습니다.'); location.href='/myQna/list.do?memberId="+myQnaWriter+"';</script>";
		}else {
			return "<script>alert('문의 등록을 실패하였습니다.'); history.back();</script>";
		}
	}
	@RequestMapping(value="/myQna/modify.do", method=RequestMethod.GET)
	public String showModifyQnaView(
			@RequestParam("myQnaNo") int myQnaNo
			, Model model
			) {
		Qna myQna = service.selectOneByNo(myQnaNo);
		model.addAttribute("myQna", myQna);
		return "qna/myQnaModify";
	}
	
	@RequestMapping(value="/myQna/modify.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String modifyQna(
			@RequestParam("myQnaNo") int myQnaNo
			, @RequestParam("qnaList") String myQnaTitle
			, @RequestParam("content") String myQnaContent
			, @RequestParam("writer") String myQnaWriter
			, @RequestParam("password") String myQnaPw
			) {
		Qna qna = new Qna(myQnaNo, myQnaTitle, myQnaContent, myQnaWriter, myQnaPw);
		int result = service.updateQna(qna);
		if(result > 0) {
			return "<script>alert('문의가 수정되었습니다.'); location.href='/myQna/list.do?memberId="+myQnaWriter+"&currentPage=1';</script>";
		}else {
			return "<script>alert('문의 수정을 실패하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/myQna/delete.do", produces="text/html;charset=UTF-8;", method=RequestMethod.GET)
	public @ResponseBody String deleteQna(
			@RequestParam("memberId") String memberId
			, @RequestParam("myQnaNo") int myQnaNo
			) {
		int result = service.deleteQna(myQnaNo);
		if(result > 0) {
			return "<script>alert('삭제가 완료되었습니다.'); location.href='/myQna/list.do?memberId="+memberId+"';</script>";
		}else {
			return "<script>alert('오류가 발생하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/myQna/detail.do", method=RequestMethod.GET)
	public String showDetailQna(
			@RequestParam("myQnaNo") int myQnaNo
			, Model model
			) {
		Qna qna = service.selectOneByNo(myQnaNo);
		model.addAttribute("myQna", qna);
		return "qna/myQnaView";
	}
	
	@RequestMapping(value="/qna/list.do", method=RequestMethod.GET)
	public String showAllQnaList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		int totalCount = service.getAllListCount();
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Qna> qList = service.selectAllQnaList(pInfo);
		model.addAttribute("qList", qList);
		model.addAttribute("pInfo", pInfo);
		return "qna/allQna";
	}

	@RequestMapping(value="/myQna/list.do", method=RequestMethod.GET)
	public String showMyQnaList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, @RequestParam("memberId") String myQnaWriter
			, Model model
			) {
		int totalCount = service.getMyListCount(myQnaWriter);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Qna> qList = service.selectMyQnaList(pInfo, myQnaWriter);
		model.addAttribute("qList", qList);
		model.addAttribute("pInfo", pInfo);
		System.out.println(pInfo.toString());
		return "qna/myQna";
	}
	
	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		if(totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		}else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, naviTotalCount, startNavi, endNavi, totalCount);
		return pi;
	}
}
