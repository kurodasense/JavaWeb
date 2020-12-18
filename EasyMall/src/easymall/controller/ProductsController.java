package easymall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easymall.po.Products;
import easymall.service.ProductsServiceImpl;

@Controller("productsController")
public class ProductsController {
	@Autowired
	private ProductsServiceImpl productsService;
	@RequestMapping("/prodlist")
	public String prodlist(String name, String category, String minprice, String maxprice, Model model) {
		//查找商品表中所有的商品类别
		List<String> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
		
		// 为搜索条件设置默认值，并检查条件是否合法
		double _minPrice = 0;
		double _maxPrice = Double.MAX_VALUE;
		
		String reg = "^\\d+$";// 只能输入数字
		if(minprice != null && !"".equals(minprice.trim()) && minprice.matches(reg)) {
			_minPrice = Double.parseDouble(minprice);
		}
		if(maxprice != null && !"".equals(maxprice.trim()) && maxprice.matches(reg)) {
			// 如果最高价格大于等于最低价格
			if(Double.parseDouble(maxprice) >= _minPrice) {
				_maxPrice = Double.parseDouble(maxprice);
			}
		}
		
		// 创建map, 用于存放查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("category", category);
		map.put("minPrice", _minPrice);
		map.put("maxPrice", _maxPrice);
		// 根据条件查询符合条件的商品信息
		List<Products> products = productsService.prodlist(map);
		// 回填查询数据
		model.addAttribute("name", name);
		model.addAttribute("minPrice", _minPrice);
		model.addAttribute("maxPrice", _maxPrice);
		// 查询结果暴露给前端
		model.addAttribute("products", products);
		// 返回到/WEB-INF/jsp/prod_list.jsp
		return "prod_list";
	}
	
	@RequestMapping("/prodInfo")
	public String prodInfo(String pid, Model model) {
		Products product = productsService.oneProduct(pid);
		model.addAttribute("product", product);
		//返回到/WEB-INF/jsp/prod_info.jsp
		return "prod_info";
	}
	
	@RequestMapping(value="/prodclass/{proclass}", method=RequestMethod.GET)
	public String prodclass(@PathVariable String proclass, Model model) {
		List<Products> products = productsService.proclass(proclass);
		model.addAttribute("products", products);
		return "forward:/WEB-INF/jsp/prod_list.jsp";
	}
	
}
