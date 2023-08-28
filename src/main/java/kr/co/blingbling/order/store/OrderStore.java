package kr.co.blingbling.order.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.order.domain.Order;

public interface OrderStore {
	
	/**
	 * 주문 등록 Store
	 * @param session
	 * @param order
	 * @return int
	 */
	public int insertOrder(SqlSession session, Order order);
	/**
	 * 주문 목록 조회 Store
	 * @param session
	 * @param memberId
	 * @return List<Order>
	 */
	public List<Order> selectOrderList(SqlSession session, String memberId);

}
