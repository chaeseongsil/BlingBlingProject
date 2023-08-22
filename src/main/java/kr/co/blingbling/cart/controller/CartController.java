package kr.co.blingbling.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.blingbling.cart.domain.Cart;
import kr.co.blingbling.cart.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@RequestMapping(value="/cart/insert.do", produces="text/html;charset=UTF-8;", method=RequestMethod.GET)
	public @ResponseBody String addCart(
			@RequestParam("productNo") int productNo
			, @RequestParam("productColor") String productColor
			, @RequestParam("amount") int amount
			, @RequestParam("productPrice") int cartPrice
			, @RequestParam("memberId") String memberId
			, @RequestParam("image") String pImagePath
			, Model model
			) {
		if(memberId == null || memberId.trim().length() == 0) {
			return "<script>alert('로그인이 필요한 서비스입니다.'); location.href='/member/login.do';</script>";
		}else {
			Cart cart = new Cart(memberId, productNo, productColor, pImagePath, amount, cartPrice);
			int result = service.insertCart(cart);
			if(result > 0) {
				return "<script>if(confirm('장바구니에 등록되었습니다. 장바구니로 이동하시겠습니까?')){"
						+ " location.href='/cart/list.do'"
						+ "}else {"
						+ "	history.back();"
						+ "}</script>";
			}else {
				return "<script>alert('장바구니 등록 실패'); history.back();</script>";
			}
		}
	}
	
	@RequestMapping(value="/cart/list.do", method=RequestMethod.GET)
	public String showCartList(
			@SessionAttribute("memberId") String memberId
			, Model model
			) {
		List<Cart> cList = service.selectAllCarts(memberId);
		model.addAttribute("cList", cList);
		return "order/cart";
	}
}
