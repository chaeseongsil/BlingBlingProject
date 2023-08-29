package kr.co.blingbling.order.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.order.domain.PageInfo;
import kr.co.blingbling.order.domain.Order;
import kr.co.blingbling.order.service.OrderService;
import kr.co.blingbling.order.store.OrderStore;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private OrderStore oStore;
	
	@Override
	public int insertOrder(Order order) {
		int result = oStore.insertOrder(session, order);
		return result;
	}

	@Override
	public List<Order> selectOrderList(String memberId, PageInfo pInfo) {
		List<Order> oList = oStore.selectOrderList(session, memberId, pInfo);
		return oList;
	}

	@Override
	public int getListCount(String memberId) {
		int result = oStore.getListCount(session, memberId);
		return result;
	}

	@Override
	public Order selectOneByNo(String orderNo) {
		Order order = oStore.selectOneByNo(session, orderNo);
		return order;
	}

}
