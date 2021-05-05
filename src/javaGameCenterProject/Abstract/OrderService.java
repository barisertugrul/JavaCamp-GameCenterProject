package javaGameCenterProject.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Cart;
import javaGameCenterProject.Entities.Order;
import javaGameCenterProject.Entities.OrderDetail;

public interface OrderService {
	int add(Order order);
	void addDetail(OrderDetail orderDetail);
	void update(Order order);
	void updateDetail(OrderDetail orderDetail);
	void delete(Order order);
	void purchase(Cart cart);
	void confirmOrderDetail(OrderDetail orderDetail);
	void cancelOrderDetail(OrderDetail orderDetail);
	List<Order> getAll();
	List<Order> getByUserId(int userId);
	Order getById(int id);
	List<OrderDetail> getAllDetails();
	List<OrderDetail> getDetailsByOrderId(int orderId);
	OrderDetail getDetailById(int id);
	void printInvoice(int orderId);
}
