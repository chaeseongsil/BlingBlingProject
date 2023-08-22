package kr.co.blingbling.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blingbling.product.domain.Product;
import kr.co.blingbling.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/product/shopList.do", method=RequestMethod.GET)
	public String showAllProductView(Model model) {
		List<Product> pList = service.selectAllProduct();
		model.addAttribute("pList", pList);
		return "product/shopPage";
	}
	
	@RequestMapping(value="/product/shopDesc.do", method=RequestMethod.GET)
	public String showProductDetail(
			@RequestParam("productNo") int productNo
			, Model model
			) {
		Product product = service.selectOneByNo(productNo);
		model.addAttribute("product", product);
		return "product/shopDesc";
	}
}
