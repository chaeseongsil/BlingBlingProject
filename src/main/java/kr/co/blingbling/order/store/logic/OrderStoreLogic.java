package kr.co.blingbling.order.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.order.domain.Order;
import kr.co.blingbling.order.domain.PageInfo;
import kr.co.blingbling.order.store.OrderStore;

@Repository
public class OrderStoreLogic implements OrderStore{

	@Override
	public int insertOrder(SqlSession session, Order order) {
		int result = session.insert("OrderMapper.insertOrder", order);
		return result;
	}

	@Override
	public List<Order> selectOrderList(SqlSession session, String memberId, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int currentPage = pInfo.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Order> oList = session.selectList("OrderMapper.selectOrderList", memberId, rowBounds);
		return oList;
	}

	@Override
	public int getListCount(SqlSession session, String memberId) {
		int result = session.selectOne("OrderMapper.getListCount", memberId);
		return result;
	}

	@Override
	public Order selectOneByNo(SqlSession session, String orderNo) {
		Order order = session.selectOne("OrderMapper.selectOneByNo", orderNo);
		return order;
	}
	
}
