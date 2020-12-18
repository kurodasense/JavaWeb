package easymall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import easymall.po.Orders;

@Repository("orderDao")
@Mapper
public interface OrderDao {
	// 添加订单
	void addOrder(Orders myOrder);
	// 显示订单
	List<Orders> findOrderByUserId(Integer user_id);
}
