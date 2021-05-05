package javaGameCenterProject.Concrete;

import java.util.List;

import javaGameCenterProject.Abstract.CampaignService;
import javaGameCenterProject.Data.Abstract.CampaignDbService;
import javaGameCenterProject.Entities.Campaign;

public class CampaignManager implements CampaignService {
	
	CampaignDbService _campaignDb;

	public CampaignManager(CampaignDbService campaignDb) {
		this._campaignDb = campaignDb;
	}

	@Override
	public void add(Campaign campaign) {
		_campaignDb.add(campaign);
		
	}

	@Override
	public void update(Campaign campaign) {
		_campaignDb.update(campaign);
		
	}

	@Override
	public void delete(Campaign campaign) {
		_campaignDb.delete(campaign);
		
	}

	@Override
	public Campaign getById(int Id) {
		return _campaignDb.getById(Id);
	}

	@Override
	public List<Campaign> getAll() {
		return _campaignDb.getAll();
	}

	@Override
	public double calculateDiscount(int campaignId, double amount) {
		Campaign campaign = getById(campaignId);
		return amount * campaign.getDiscount();
	}

}
