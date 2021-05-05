package javaGameCenterProject.Data.Concrete;

import java.util.ArrayList;
import java.util.List;

import javaGameCenterProject.Data.Database;
import javaGameCenterProject.Data.Abstract.OrderDbService;
import javaGameCenterProject.Entities.Cart;
import javaGameCenterProject.Entities.Order;
import javaGameCenterProject.Entities.OrderDetail;

public class OrderDbManager implements OrderDbService {

	@Override
	public int add(Order order) {
		List<Order> orders = Database.getOrders();
		int lastId = Database.getOrderId();
		lastId++;
		order.setId(lastId);
		if(orders.add(order)) {
			Database.setOrderId(lastId);
			return lastId;
		}
		
		lastId--;
		return 0;
	}

	@Override
	public boolean update(Order order) {
		List<Order> orders = Database.getOrders();
		for (Order orderItem : orders) {
			if (orderItem.getId() == order.getId()) {
				int index = orders.indexOf(orderItem);
				orders.set(index, order);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Order order) {
		List<Order> orders = Database.getOrders();
		orders.remove(order);
		return true;
	}

	@Override
	public List<Order> getAll() {
		return Database.getOrders();
	}

	@Override
	public Order getById(int id) {
		List<Order> orders = Database.getOrders();
		for (Order orderItem : orders) {
			if (orderItem.getId() == id) {
				return orderItem;
			}
		}
		return null;
	}

	@Override
	public boolean addDetail(OrderDetail orderDetail) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		int lastId = Database.getOrderDetailId();
		lastId++;
		orderDetail.setId(lastId);
		if(orderDetails.add(orderDetail)) {
			Database.setOrderDetailId(lastId);
			return true;
		}
		
		lastId--;
		return false;
	}

	@Override
	public boolean confirmOrderDetail(OrderDetail orderDetail) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		for (OrderDetail orderDetailItem : orderDetails) {
			if (orderDetailItem.getId() == orderDetail.getId()) {
				int index = orderDetails.indexOf(orderDetailItem);
				orderDetail.setOrderConfirmation(true);
				orderDetails.set(index, orderDetail);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean cancelOrderDetail(OrderDetail orderDetail) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		orderDetails.remove(orderDetail);
		return true;
	}

	@Override
	public List<Order> getByUserId(int userId) {
		List<Order> orders = Database.getOrders();
		List<Order> filteredOrders = new ArrayList<Order>();
		for (Order orderItem : orders) {
			if (orderItem.getUserId() == userId) {
				filteredOrders.add(orderItem);
			}
		}
		if (filteredOrders.size() > 0) {
			return filteredOrders;
		}
		return null;
	}

	@Override
	public List<OrderDetail> getAllDetails() {
		return Database.getOrderDetails();
	}

	@Override
	public List<OrderDetail> getDetailsByOrderId(int orderId) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		List<OrderDetail> filteredOrderDetails = new ArrayList<OrderDetail>();
		for (OrderDetail orderDetailItem : orderDetails) {
			if (orderDetailItem.getOrderId() == orderId) {
				filteredOrderDetails.add(orderDetailItem);
			}
		}
		if (filteredOrderDetails.size() > 0) {
			return filteredOrderDetails;
		}
		return null;
	}

	@Override
	public OrderDetail getDetailById(int id) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		for (OrderDetail orderDetailItem : orderDetails) {
			if (orderDetailItem.getId() == id) {
				return orderDetailItem;
			}
		}
		return null;
	}

	@Override
	public boolean updateDetail(OrderDetail orderDetail) {
		List<OrderDetail> orderDetails = Database.getOrderDetails();
		for (OrderDetail orderDetailItem : orderDetails) {
			if (orderDetailItem.getId() == orderDetail.getId()) {
				int index = orderDetails.indexOf(orderDetailItem);
				orderDetails.set(index, orderDetail);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean purchase(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

}
