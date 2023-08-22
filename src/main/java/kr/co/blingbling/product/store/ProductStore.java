package kr.co.blingbling.product.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.product.domain.Product;

public interface ProductStore {
	
	/**
	 * 전체 상품 리스트 조회 Store
	 * @param session 
	 * @return List<Product>
	 */
	public List<Product> selectAllProduct(SqlSession session);
	/**
	 * 상품 상세정보 번호로 조회 Store
	 * @param session 
	 * @param productNo
	 * @return Product
	 */
	public Product selectOneByNo(SqlSession session, int productNo);

}
