package easymall.service;

import java.util.List;
import java.util.Map;

import easymall.po.Products;

public interface ProductsService {
	//������Ʒ���
	public List<String> allcategorys();
	//������Ʒ
	public List<Products> prodlist(Map<String, Object> map);
	//����pid���ҵ�����Ʒ
	public Products oneProduct(String pid);
	//���ݷ��������Ʒ
	public List<Products> proclass(String proclass);
}
