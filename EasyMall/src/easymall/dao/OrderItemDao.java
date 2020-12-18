package easymall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import easymall.po.OrderItem;

@Repository("orderItemDao")
@Mapper
public interface OrderItemDao {
	// 添加订单 商品信息
	void addOrderItem(OrderItem orderItem);
	// 显示订单 商品信息
	List<OrderItem> orderitem(String order_id);
}
