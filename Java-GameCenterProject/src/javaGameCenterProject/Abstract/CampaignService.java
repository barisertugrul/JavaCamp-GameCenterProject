package javaGameCenterProject.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Campaign;

public interface CampaignService {
	void add(Campaign campaign);
	void update(Campaign campaign);
	void delete(Campaign campaign);
	List<Campaign> getAll();
	Campaign getById(int id);
	double calculateDiscount(int campaignId, double amount);
}
