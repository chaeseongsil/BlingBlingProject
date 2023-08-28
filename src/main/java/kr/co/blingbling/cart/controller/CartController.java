package kr.co.blingbling.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.blingbling.cart.domain.Cart;
import kr.co.blingbling.cart.service.CartService;
import kr.co.blingbling.member.domain.Member;
import kr.co.blingbling.member.service.MemberService;

@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/cart/insert.do", produces="text/html;charset=UTF-8;", method=RequestMethod.GET)
	public @ResponseBody String addCart(
			@RequestParam("productNo") int productNo
			, @RequestParam("productPrice") int cartPrice
			, @RequestParam("pImagePath") String pImagePath
			, @RequestParam("memberId") String memberId
			, @RequestParam("productName") String [] productName
			, @RequestParam("productColor") String [] productColor
			, @RequestParam("amount") int [] amount
			, Model model
			) {
		int result = 0;
		if(memberId == null || memberId.trim().length() == 0) {
			return "<script>alert('로그인이 필요한 서비스입니다.'); location.href='/member/login.do';</script>";
		}else {
			for(int i = 0; i < productName.length-1; i++) {
				Cart cart = new Cart(memberId, productNo, productName[i], productColor[i], pImagePath, amount[i], cartPrice);
				result += service.insertCart(cart);
			}
			if(result >= productName.length-1) {
				return "<script>if(confirm('장바구니에 등록되었습니다. 장바구니로 이동하시겠습니까?')){"
						+ " location.href='/cart/list.do?memberId="+memberId+"'"
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
			@RequestParam("memberId") String memberId
			, Model model
			) {
		List<Cart> cList = service.selectAllCarts(memberId);
		model.addAttribute("cList", cList);
		return "order/cart";
	}
	
	@RequestMapping(value="/cart/delete.do", produces="text/html;charset=UTF-8;", method=RequestMethod.GET)
	public @ResponseBody String deleteCart(
			@RequestParam("memberId") String memberId
			, @RequestParam("cartNo") int [] cartNo
			, Model model
			) {
		int result = 0;
		for(int i = 0; i < cartNo.length; i++) {
			result += service.deleteCart(cartNo[i]);
		}
		if(result >= cartNo.length) {
			return "<script>alert('"+result+"개의 목록을 삭제하였습니다.'); location.href='/cart/list.do?memberId="+memberId+"'</script>";
		}else {
			return "<script>alert('삭제를 실패하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/cart/sendOrder.do", method=RequestMethod.GET)
	public String showOrderForm(
			@RequestParam("memberId") String memberId
			, @RequestParam("cartNo") int [] cartNo
			, Model model
			) {
		List<Cart> cList = new ArrayList<Cart>();
		for(int i = 0; i < cartNo.length; i++) {
			Cart cart = service.selectOneByNo(cartNo[i]);
			cList.add(cart);
		}
		Member member = mService.selectOneById(memberId);
		model.addAttribute("cList", cList);
		model.addAttribute("member", member);
		return "order/order";
			
	}
}
