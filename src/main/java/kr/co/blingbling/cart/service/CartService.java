package kr.co.blingbling.cart.service;

import java.util.List;

import kr.co.blingbling.cart.domain.Cart;

public interface CartService {
	
	/**
	 * 장바구니 등록 Service
	 * @param cart
	 * @return int
	 */
	public int insertCart(Cart cart);
	/**
	 * 회원별 장바구니 조회 Service
	 * @param memberId 
	 * @return
	 */
	public List<Cart> selectAllCarts(String memberId);
	/**
	 * 장바구니 삭제 Service
	 * @param cartNo
	 * @return int
	 */
	public int deleteCart(int cartNo);

}
