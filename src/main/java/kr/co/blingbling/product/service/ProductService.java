package kr.co.blingbling.product.service;

import java.util.List;

import kr.co.blingbling.product.domain.Product;

public interface ProductService {
	
	/**
	 * 전체 상품 리스트 조회 Service
	 * @return List<Product>
	 */
	public List<Product> selectAllProduct();
	/**
	 * 상품 상세정보 번호로 조회 Service
	 * @param productNo
	 * @return Product
	 */
	public Product selectOneByNo(int productNo);

}
