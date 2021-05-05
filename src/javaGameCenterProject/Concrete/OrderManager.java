package javaGameCenterProject.Concrete;

import java.time.LocalDate;
import java.util.List;

import javaGameCenterProject.Abstract.CampaignService;
import javaGameCenterProject.Abstract.GameService;
import javaGameCenterProject.Abstract.OrderService;
import javaGameCenterProject.Data.Abstract.OrderDbService;
import javaGameCenterProject.Entities.Cart;
import javaGameCenterProject.Entities.Game;
import javaGameCenterProject.Entities.Order;
import javaGameCenterProject.Entities.OrderDetail;

public class OrderManager implements OrderService {
	
	OrderDbService _orderdb;
	CampaignService _campaignManager;
	GameService _gameManager;

	public OrderManager(OrderDbService orderdb, CampaignService campaignManager, GameService gameManager) {
		_orderdb = orderdb;
		_campaignManager = campaignManager;
		_gameManager = gameManager;
	}

	@Override
	public int add(Order order) {
		return _orderdb.add(order);
	}

	@Override
	public void update(Order order) {
		_orderdb.update(order);
		
	}

	@Override
	public void delete(Order order) {
		List<OrderDetail> details = getDetailsByOrderId(order.getId());
		for (OrderDetail orderDetail : details) {
			cancelOrderDetail(orderDetail);
		}
		_orderdb.delete(order);
		
	}

	@Override
	public void updateDetail(OrderDetail orderDetail) {
		_orderdb.updateDetail(orderDetail);
		
	}

	@Override
	public void addDetail(OrderDetail orderDetail) {
		_orderdb.addDetail(orderDetail);
		
	}

	@Override
	public void purchase(Cart cart) {
		LocalDate orderDate = LocalDate.now();
		int orderId = add(new Order(cart.getUserId(), cart.getCampaignId() , orderDate));
		double amount = 0;
		if (orderId>0) {
			for (OrderDetail detail : cart.getOrderItems()) {
				addDetail(detail);
				Game game = _gameManager.getById(detail.getGameId());
				amount += detail.getQuantity() * game.getUnitPrice();
			}
			System.out.println("Sipariþiniz alýndý. Onay bekliyor.");
			int campaignId = cart.getCampaignId();
			if(campaignId > 0) {
				double discount = _campaignManager.calculateDiscount(campaignId, amount);
				System.out.println(_campaignManager.getById(campaignId).getCampaignName() + 
						" adlý kampanyadan yararlandýnýz ve " + discount + " TL indirim kazandýnýz.");
			}
		}
	}

	@Override
	public void confirmOrderDetail(OrderDetail orderDetail) {
		_orderdb.confirmOrderDetail(orderDetail);
		
	}

	@Override
	public void cancelOrderDetail(OrderDetail orderDetail) {
		_orderdb.cancelOrderDetail(orderDetail);
		
	}

	@Override
	public List<Order> getAll() {
		return _orderdb.getAll();
	}

	@Override
	public List<Order> getByUserId(int userId) {
		return _orderdb.getByUserId(userId);
	}

	@Override
	public Order getById(int id) {
		return _orderdb.getById(id);
	}

	@Override
	public List<OrderDetail> getAllDetails() {
		return _orderdb.getAllDetails();
	}

	@Override
	public List<OrderDetail> getDetailsByOrderId(int orderId) {
		return _orderdb.getDetailsByOrderId(orderId);
	}

	@Override
	public OrderDetail getDetailById(int id) {
		return _orderdb.getDetailById(id);
	}

	@Override
	public void printInvoice(int orderId) {
		// TODO Order, Order Details List and Campaign infos, Total Amount - print as table
		
	}

}
