package kr.co.blingbling.order.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import kr.co.blingbling.cart.domain.Cart;
import kr.co.blingbling.cart.service.CartService;
import kr.co.blingbling.order.domain.Order;
import kr.co.blingbling.order.domain.PageInfo;
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
			, @RequestParam("cartNums") String cartNo
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Random rand = new Random();
		String strResult = "-";
		for(int i = 0; i < 6; i++) {
			int result = rand.nextInt(9)+1;
			strResult += result + "";
		}
		String orderNo = sdf.format(new Date(System.currentTimeMillis())) + strResult;
		String memberId = (String) session.getAttribute("memberId");
		Order order = new Order(orderNo, memberId, productNo, orderName, memberName, memberPostCode, memberAddr1, memberAddr2, memberPhone, memberEmail, payment, orderPrice, cartNo);
		int result = service.insertOrder(order);
		if(result > 0) {
			String [] cartNums = cartNo.split(",");
			for(int i = 0; i < cartNums.length; i++) {
				cService.updateCartStatus(Integer.parseInt(cartNums[i]));
			}
			return "<script>alert('주문이 완료되었습니다.'); location.href='/order/list.do';</script>";
		}else {
			return "<script>alert('주문 실패'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/order/list.do", method=RequestMethod.GET)
	public String showOrderList(
			HttpSession session
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model
			) {
		String memberId = (String) session.getAttribute("memberId");
		int totalCount = service.getListCount(memberId);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Order> oList = service.selectOrderList(memberId, pInfo);
		model.addAttribute("oList", oList);
		model.addAttribute("pInfo", pInfo);
		return "order/myOrderList";
	}
	
	@RequestMapping(value="/order/detail.do", method=RequestMethod.GET)
	public String showOrderDetail(
			@RequestParam("orderNo") String orderNo
			, Model model
			) {
		Order order = service.selectOneByNo(orderNo);
		String [] cartNums = order.getCartNums().split(",");
		List<Cart> cList = new ArrayList<Cart>(); 
		for(int i = 0; i < cartNums.length; i++) {
			Cart cart = cService.selectCartStatusN(Integer.parseInt(cartNums[i]));
			cList.add(cart);
		}
		model.addAttribute("order", order);
		model.addAttribute("cList", cList);
		return "order/myOrderListDesc";
	}
	
	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
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
