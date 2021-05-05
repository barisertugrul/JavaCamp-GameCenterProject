package javaGameCenterProject.Concrete;

import javaGameCenterProject.Abstract.ServiceFactory;
import javaGameCenterProject.Abstract.UserValidationService;
import javaGameCenterProject.Adapters.MernisServiceAdapter;
import javaGameCenterProject.Data.Abstract.CampaignDbService;
import javaGameCenterProject.Data.Abstract.GameDbService;
import javaGameCenterProject.Data.Abstract.GamerDbService;
import javaGameCenterProject.Data.Abstract.OrderDbService;
import javaGameCenterProject.Data.Abstract.UserDbService;
import javaGameCenterProject.Data.Concrete.CampaignDbManager;
import javaGameCenterProject.Data.Concrete.GamerDbManager;
import javaGameCenterProject.Data.Concrete.OrderDbManager;
import javaGameCenterProject.Data.Concrete.UserDbManager;

public class ServiceFactoryManager implements ServiceFactory {

	UserDbService _userDbService;
	GamerDbService _gamerDbService;
	GameDbService _gameDbService;
	CampaignDbService _campaignDbService;
	OrderDbService _orderDbService;
	UserValidationService _userValidationService;
	
	/*
	 * veya bu sýnýfý bir configürasyon sýnýfý olarak kabul edersek; 
	 * UserDbService _userDbService = new UserDbManager(); 
	 * GamerDbService _gamerDbService = new GamerDbManager(); 
	 * GameDbService _gameDbService = new GamerDbManager();
	 * CampaignDbService _campaignDbService = new CampaignDbManager();
	 * OrderDbService _orderDbService = new OrderDbManager(); 
	 * UserValidationService _userValidationService = new MernisServiceAdapter();
	 */
	
	@Override
	public UserDbService createUserDbService() {
		return _userDbService;
	}

	@Override
	public void release(UserDbService userDbService) {
		_userDbService = userDbService;
		
	}

	@Override
	public GamerDbService createGamerDbService() {
		return _gamerDbService;
	}

	@Override
	public void release(GamerDbService gamerDbService) {
		_gamerDbService = gamerDbService;
		
	}

	@Override
	public GameDbService createGameDbService() {
		return _gameDbService;
	}

	@Override
	public void release(GameDbService gameDbService) {
		_gameDbService = gameDbService;
		
	}

	@Override
	public CampaignDbService createCampaignDbService() {
		return _campaignDbService;
	}

	@Override
	public void release(CampaignDbService campaignDbService) {
		_campaignDbService = campaignDbService;
		
	}

	@Override
	public OrderDbService createOrderDbService() {
		return _orderDbService;
	}

	@Override
	public void release(OrderDbService orderDbService) {
		_orderDbService = orderDbService;
		
	}

	@Override
	public UserValidationService createUserValidationService() {
		return _userValidationService;
	}

	@Override
	public void release(UserValidationService userValidationService) {
		_userValidationService = userValidationService;
		
	}

}
