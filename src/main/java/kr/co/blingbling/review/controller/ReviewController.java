package kr.co.blingbling.review.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.blingbling.review.domain.PageInfo;
import kr.co.blingbling.product.domain.Product;
import kr.co.blingbling.product.service.ProductService;
import kr.co.blingbling.review.domain.Review;
import kr.co.blingbling.review.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService service;
	@Autowired
	private ProductService pService;
	
	@RequestMapping(value="/review/insert.do", method=RequestMethod.GET)
	public String showWriteForm(
			@RequestParam("productNo") int productNo
			, Model model
			) {
		Product product = pService.selectOneByNo(productNo);
		model.addAttribute("product", product);
		return "review/myReviewWrite";
	}
	
	@RequestMapping(value="/review/insert.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String insertReview(
			@ModelAttribute Review review
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpSession session
			, HttpServletRequest request
			, Model model
			) {
		try {
			String reviewWriter = (String) session.getAttribute("memberId");
			if(reviewWriter != null && !reviewWriter.equals("")) {
				review.setReviewWriter(reviewWriter);
				if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
					Map<String, Object> rMap = this.saveFile(request, uploadFile);
					review.setReviewFilename((String)rMap.get("fileName"));
					review.setReviewFileRename((String)rMap.get("fileRename"));
					review.setReviewFilepath((String)rMap.get("filePath"));
					review.setReviewFileLength((long)rMap.get("fileLength"));
				}
				int result = service.insertReview(review);
				if(result > 0) {
					return "<script>alert('리뷰가 등록되었습니다.'); location.href='/review/list.do';</script>";
				}else {
					return "<script>alert('리뷰 등록을 실패하였습니다.'); history.back();</script>";
				}
			}else {
				return "<script>alert('리뷰 등록을 실패하였습니다.'); history.back();</script>";
			}
		} catch (Exception e) {
			return "<script>alert('리뷰 등록 중 오류가 발생하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/review/modify.do", method=RequestMethod.GET)
	public String showModifyForm(
			@RequestParam("reviewNo") int reviewNo
			, Model model
			) {
		Review review = service.selectOneByNo(reviewNo);
		model.addAttribute("review", review);
		return "review/modifyReview";
	}
	
	@RequestMapping(value="/review/list.do", method=RequestMethod.GET)
	public String showAllReviewList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model
			) {
		int totalCount = service.getListCount();
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Review> rList = service.selectReviewList(pInfo);
		model.addAttribute("rList", rList);
		model.addAttribute("pInfo", pInfo);
		return "review/reviewList";
	}
	
	@RequestMapping(value="/review/reviewDetail.do", method=RequestMethod.GET)
	public String showReviewDetail(
			@RequestParam("reviewNo") int reviewNo
			, Model model
			) {
		Review review = service.selectOneByNo(reviewNo);
		model.addAttribute("review", review);
		return "review/reviewDetail";
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
	
	private Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		// 파일 이름 구하기
		String fileName = uploadFile.getOriginalFilename();
		// resources 경로 구하기
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 파일 저장 경로 구하기
		String saveFolder = root + "\\ruploadFiles";
		// 파일 저장 전 폴더 만들기
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일 확장자 구하기
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		// 시간으로 파일 리네임하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String fileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+extension;
		// 파일 저장
		String savePath = saveFolder + "\\" + fileRename;
		File file = new File(savePath);
		uploadFile.transferTo(file);
		// 파일 크기 구하기
		long fileLength = uploadFile.getSize();
		// Map에 넣어주기
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/ruploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		// Map 리턴
		return fileMap;
	}
	
}
