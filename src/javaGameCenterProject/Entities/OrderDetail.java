package javaGameCenterProject.Entities;

import javaGameCenterProject.Abstract.Entity;

public class OrderDetail implements Entity {
	private int id;
	private int orderId;
	private int gameId;
	private int quantity;
	private boolean orderConfirmation;
	
	public OrderDetail(int gameId, int quantity) {
		
		this.gameId = gameId;
		this.quantity = quantity;
	}
	
	public OrderDetail(int orderId, int gameId, int quantity) {
		
		this(gameId, quantity);
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean getOrderConfirmation() {
		return orderConfirmation;
	}

	public void setOrderConfirmation(boolean orderConfirmation) {
		this.orderConfirmation = orderConfirmation;
	}
}
