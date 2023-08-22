package kr.co.blingbling.cart.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.cart.domain.Cart;
import kr.co.blingbling.cart.service.CartService;
import kr.co.blingbling.cart.store.CartStore;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartStore cStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertCart(Cart cart) {
		int result = cStore.insertCart(session, cart);
		return result;
	}

	@Override
	public List<Cart> selectAllCarts(String memberId) {
		List<Cart> cList = cStore.selectAllCarts(session, memberId);
		return cList;
	}
}