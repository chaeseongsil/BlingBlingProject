package kr.co.blingbling.product.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.product.domain.Product;
import kr.co.blingbling.product.store.ProductStore;

@Repository
public class ProductStoreLogic implements ProductStore{

	@Override
	public List<Product> selectAllProduct(SqlSession session) {
		List<Product> pList = session.selectList("ProductMapper.selectAllProduct");
		return pList;
	}

	@Override
	public Product selectOneByNo(SqlSession session, int productNo) {
		Product product = session.selectOne("ProductMapper.selectOneByNo", productNo);
		return product;
	}
	
}
