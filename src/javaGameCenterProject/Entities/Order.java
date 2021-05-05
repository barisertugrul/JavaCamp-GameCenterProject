package javaGameCenterProject.Entities;

import java.time.LocalDate;

import javaGameCenterProject.Abstract.Entity;

public class Order implements Entity {
	
	private int id;
	private int userId;
	private int campaignId;
	private LocalDate orderDate;
	
	public Order(int userId, int campaignId, LocalDate orderDate) {
		super();
		this.userId = userId;
		this.campaignId = campaignId;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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



	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
}
