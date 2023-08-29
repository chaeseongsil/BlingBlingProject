package kr.co.blingbling.order.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.order.domain.PageInfo;
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
	 * @param pInfo 
	 * @return List<Order>
	 */
	public List<Order> selectOrderList(SqlSession session, String memberId, PageInfo pInfo);
	/**
	 * 주문 목록 총 갯수 조회 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int getListCount(SqlSession session, String memberId);
	/**
	 * 주문 상세보기 Store
	 * @param session
	 * @param orderNo
	 * @return Order
	 */
	public Order selectOneByNo(SqlSession session, String orderNo);

}
