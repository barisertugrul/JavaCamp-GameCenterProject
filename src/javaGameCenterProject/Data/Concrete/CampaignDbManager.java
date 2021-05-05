package javaGameCenterProject.Data.Concrete;

import java.util.List;

import javaGameCenterProject.Data.Database;
import javaGameCenterProject.Data.Abstract.CampaignDbService;
import javaGameCenterProject.Entities.Campaign;

public class CampaignDbManager implements CampaignDbService {

	@Override
	public int add(Campaign campaign) {
		List<Campaign> campaigns = Database.getCampaigns();
		int lastId = Database.getCampaignId();
		lastId++;
		campaign.setId(lastId);
		if(campaigns.add(campaign)) {
			Database.setCampaignId(lastId);
			return lastId;
		}
		
		lastId--;
		return 0;
	}

	@Override
	public boolean update(Campaign campaign) {
		List<Campaign> campaigns = Database.getCampaigns();
		for (Campaign campaignItem : campaigns) {
			if (campaignItem.getId() == campaign.getId()) {
				int index = campaigns.indexOf(campaignItem);
				campaigns.set(index, campaign);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Campaign campaign) {
		List<Campaign> campaigns = Database.getCampaigns();
		campaigns.remove(campaign);
		return true;
	}

	@Override
	public List<Campaign> getAll() {
		return Database.getCampaigns();
	}

	@Override
	public Campaign getById(int id) {
		List<Campaign> campaigns = Database.getCampaigns();
		for (Campaign campaignItem : campaigns) {
			if (campaignItem.getId() == id) {
				return campaignItem;
			}
		}
		return null;
	}

}
