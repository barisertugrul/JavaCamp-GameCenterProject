package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Cart;
import javaGameCenterProject.Entities.Order;
import javaGameCenterProject.Entities.OrderDetail;

public interface OrderDbService {
	int add(Order order);
	boolean addDetail(OrderDetail orderDetail);
	boolean update(Order order);
	boolean updateDetail(OrderDetail orderDetail);
	boolean delete(Order order);
	List<Order> getAll();
	Order getById(int id);
	boolean purchase(Cart cart);
	boolean confirmOrderDetail(OrderDetail orderDetail);
	boolean cancelOrderDetail(OrderDetail orderDetail);
	List<Order> getByUserId(int userId);
	List<OrderDetail> getAllDetails();
	List<OrderDetail> getDetailsByOrderId(int orderId);
	OrderDetail getDetailById(int id);
}
