package javaGameCenterProject.Abstract;

import javaGameCenterProject.Data.Abstract.CampaignDbService;
import javaGameCenterProject.Data.Abstract.GameDbService;
import javaGameCenterProject.Data.Abstract.GamerDbService;
import javaGameCenterProject.Data.Abstract.OrderDbService;
import javaGameCenterProject.Data.Abstract.UserDbService;
import javaGameCenterProject.Data.Concrete.UserDbManager;

public interface ServiceFactory {

	UserDbService createUserDbService();
    void release(UserDbService userDbService);

    GamerDbService createGamerDbService();
    void release(GamerDbService gamerDbService);

    GameDbService createGameDbService();
    void release(GameDbService gameDbService);
    
    CampaignDbService createCampaignDbService();
    void release(CampaignDbService campaignDbService);
    
    OrderDbService createOrderDbService();
    void release(OrderDbService orderDbService);
    
    UserValidationService createUserValidationService();
    void release(UserValidationService userValidationService);
    
    CampaignService createCampaignService();
    void release(CampaignService campaignService);
    
    GameService createGameService();
    void release(GameService gameService);
}
