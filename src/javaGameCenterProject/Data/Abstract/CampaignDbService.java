package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Campaign;

public interface CampaignDbService {
	int add(Campaign campaign);
	boolean update(Campaign campaign);
	boolean delete(Campaign campaign);
	List<Campaign> getAll();
	Campaign getById(int id);
}
