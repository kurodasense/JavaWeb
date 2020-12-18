package easymall.service;

import java.util.List;
import java.util.Map;

import easymall.po.Products;

public interface ProductsService {
	//查找商品类别
	public List<String> allcategorys();
	//查找商品
	public List<Products> prodlist(Map<String, Object> map);
	//根据pid查找单个商品
	public Products oneProduct(String pid);
	//根据分类查找商品
	public List<Products> proclass(String proclass);
}
