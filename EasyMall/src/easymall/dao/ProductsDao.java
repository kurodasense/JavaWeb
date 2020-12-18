package easymall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import easymall.po.Products;

@Repository("productsDao")
@Mapper
public interface ProductsDao {
	//查找商品类别
	public List<String> allcategorys();
	//查找商品
	public List<Products> prodlist(Map<String, Object> map);
	//根据pid查找单个商品
	public Products oneProduct(String pid);
	//根据分类查找商品
	public List<Products> proclass(String category);
}	
