package kr.co.blingbling.order.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.order.domain.Order;
import kr.co.blingbling.order.store.OrderStore;

@Repository
public class OrderStoreLogic implements OrderStore{

	@Override
	public int insertOrder(SqlSession session, Order order) {
		int result = session.insert("OrderMapper.insertOrder", order);
		return result;
	}

	@Override
	public List<Order> selectOrderList(SqlSession session, String memberId) {
		List<Order> oList = session.selectList("OrderMapper.selectOrderList", memberId);
		return oList;
	}
	
	
}
