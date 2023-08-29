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
	 * 주문시 카트 상태 변경 Service
	 * @param cartNo
	 */
	public int updateCartStatus(int cartNo);
	/**
	 * 장바구니 삭제 Service
	 * @param cartNo
	 * @return int
	 */
	public int deleteCart(int cartNo);
	/**
	 * 장바구니 번호로 조회 Service
	 * @param cartNo
	 * @return Cart
	 */
	public Cart selectOneByNo(int cartNo);
	/**
	 * 비활성화 카트 선택 Service
	 * @param parseInt
	 * @return Cart
	 */
	public Cart selectCartStatusN(int cartNo);

}
