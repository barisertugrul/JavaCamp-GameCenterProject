package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.OrderDetail;

public interface OrderDetailDbService {
	int add(OrderDetail orderDetail);
	boolean update(OrderDetail orderDetail);
	boolean delete(OrderDetail orderDetail);
	List<OrderDetail> getAll();
	OrderDetail getById(int id);
}
