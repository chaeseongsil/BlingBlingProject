package kr.co.blingbling.cart.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.cart.domain.Cart;

public interface CartStore {
	
	/**
	 * 장바구니 등록 Store
	 * @param session
	 * @param cart
	 * @return int
	 */
	public int insertCart(SqlSession session, Cart cart);
	/**
	 * 회원별 장바구니 조회 Service
	 * @param session
	 * @param memberId 
	 * @return List<Cart>
	 */
	public List<Cart> selectAllCarts(SqlSession session, String memberId);
	/**
	 * 장바구니 삭제 Service
	 * @param session
	 * @param cartNo
	 * @return int
	 */
	public int deleteCart(SqlSession session, int cartNo);
	/**
	 * 장바구니 번호로 조회 Store
	 * @param session
	 * @param cartNo
	 * @return Cart
	 */
	public Cart selectOneByNo(SqlSession session, int cartNo);

}
