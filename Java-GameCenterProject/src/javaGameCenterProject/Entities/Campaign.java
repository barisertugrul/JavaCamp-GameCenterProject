package javaGameCenterProject.Entities;


import java.time.LocalDate;

import javaGameCenterProject.Abstract.Entity;

public class Campaign implements Entity {
	private int id;
	private String campaignName;
	private LocalDate campaignStartDate;
	private LocalDate campaignEndDate;
	private String description;
	private double discount;
	
	public Campaign() {
		
	}

	public Campaign(String campaignName, LocalDate campaignStartDate, LocalDate campaignEndDate, String description,
			double discount) {
		this.campaignName = campaignName;
		this.campaignStartDate = campaignStartDate;
		this.campaignEndDate = campaignEndDate;
		this.discount = discount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public LocalDate getCampaignStartDate() {
		return campaignStartDate;
	}

	public void setCampaignStartDate(LocalDate campaignStartDate) {
		this.campaignStartDate = campaignStartDate;
	}

	public LocalDate getCampaignEndDate() {
		return campaignEndDate;
	}

	public void setCampaignEndDate(LocalDate campaignEndDate) {
		this.campaignEndDate = campaignEndDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
