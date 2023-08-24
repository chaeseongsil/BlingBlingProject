package kr.co.blingbling.cart.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.cart.domain.Cart;
import kr.co.blingbling.cart.store.CartStore;

@Repository
public class CartServiceLogic implements CartStore{

	@Override
	public int insertCart(SqlSession session, Cart cart) {
		int result = session.insert("CartMapper.insertCart", cart);
		return result;
	}

	@Override
	public List<Cart> selectAllCarts(SqlSession session, String memberId) {
		List<Cart> cList = session.selectList("CartMapper.selectAllCarts", memberId);
		return cList;
	}

	@Override
	public int deleteCart(SqlSession session, int cartNo) {
		int result = session.delete("CartMapper.deleteCart", cartNo);
		return result;
	}

	@Override
	public Cart selectOneByNo(SqlSession session, int cartNo) {
		Cart cart = session.selectOne("CartMapper.selectOneByNo", cartNo);
		return cart;
	}
	
}
