package kr.co.blingbling.order.service;

import java.util.List;

import kr.co.blingbling.order.domain.PageInfo;
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
	 * @param pInfo 
	 * @return List<Order>
	 */
	public List<Order> selectOrderList(String memberId, PageInfo pInfo);
	/**
	 * 주문 목록 총 갯수 Service
	 * @param memberId
	 * @return int
	 */
	public int getListCount(String memberId);
	/**
	 * 주문 상세보기 Service
	 * @param orderNo
	 * @return Order
	 */
	public Order selectOneByNo(String orderNo);

}
