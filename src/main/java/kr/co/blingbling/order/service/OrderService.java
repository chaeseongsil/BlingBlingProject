package kr.co.blingbling.order.service;

import java.util.List;

import kr.co.blingbling.order.domain.Order;

public interface OrderService {
	
	/**
	 * 주문 등록 Service
	 * @param order
	 * @return int
	 */
	public int insertOrder(Order order);
	/**
	 * 주문 목록 조회 Service
	 * @param memberId
	 * @return List<Order>
	 */
	public List<Order> selectOrderList(String memberId);

}
