package kr.co.blingbling.product.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.product.domain.Product;
import kr.co.blingbling.product.service.ProductService;
import kr.co.blingbling.product.store.ProductStore;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private ProductStore pStore;
	
	@Override
	public List<Product> selectAllProduct() {
		List<Product> pList = pStore.selectAllProduct(session);
		return pList;
	}

	@Override
	public Product selectOneByNo(int productNo) {
		Product product = pStore.selectOneByNo(session, productNo);
		return product;
	}
}
