package kr.co.blingbling.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.blingbling.cart.service.CartService;
import kr.co.blingbling.order.domain.Order;
import kr.co.blingbling.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService service;
	@Autowired
	private CartService cService;
	
	@RequestMapping(value="/order/insert.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String insertOrder(
			HttpSession session
			, @RequestParam("productId") String productNo
			, @RequestParam("orderName") String orderName
			, @RequestParam("userName") String memberName
			, @RequestParam("userPost") String memberPostCode
			, @RequestParam("userPostAddr1") String memberAddr1
			, @RequestParam("userPostAddr2") String memberAddr2
			, @RequestParam("tel1") String memberPhone1
			, @RequestParam("tel2") String memberPhone2
			, @RequestParam("userEmail") String memberEmail
			, @RequestParam("selectPay") String payment
			, @RequestParam("orderPrice") int orderPrice
			) {
		String memberPhone = memberPhone1 + memberPhone2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		Random rand = new Random();
		String strResult = "-";
		for(int i = 0; i < 6; i++) {
			int result = rand.nextInt(9)+1;
			strResult += result + "";
		}
		String orderNo = sdf.format(new Date(System.currentTimeMillis())) + strResult;
		String memberId = (String) session.getAttribute("memberId");
		Order order = new Order(orderNo, memberId, productNo, orderName, memberName, memberPostCode, memberAddr1, memberAddr2, memberPhone, memberEmail, payment, orderPrice);
		int result = service.insertOrder(order);
		if(result > 0) {
			return "<script>alert('주문이 완료되었습니다.'); location.href='/order/list.do';</script>";
		}else {
			return "<script>alert('주문 실패'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/order/list.do", method=RequestMethod.GET)
	public String showOrderList(
			HttpSession session
			, Model model
			) {
		String memberId = (String) session.getAttribute("memberId");
		List<Order> oList = service.selectOrderList(memberId);
		model.addAttribute("oList", oList);
		return "order/myOrderList";
	}
}
