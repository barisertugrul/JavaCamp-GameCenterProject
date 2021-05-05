package javaGameCenterProject.Entities;

import javaGameCenterProject.Abstract.Entity;

public class Cart implements Entity {
	private int userId;
	private int campaignId;
	private OrderDetail[] orderItems;
	
	public Cart(int userId, Integer campaignId, OrderDetail[] orderItems) {
		this.userId = userId;
		this.campaignId = campaignId;
		this.orderItems = orderItems;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public OrderDetail[] getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderDetail[] orderItems) {
		this.orderItems = orderItems;
	}
}
