package kr.co.blingbling.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blingbling.product.domain.Product;
import kr.co.blingbling.product.service.ProductService;
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
}
