package javaGameCenterProject.Concrete;

import java.util.List;

import javaGameCenterProject.Abstract.BaseUserManager;
import javaGameCenterProject.Abstract.ServiceFactory;
import javaGameCenterProject.Abstract.UserValidationService;
import javaGameCenterProject.Data.Abstract.GamerDbService;
import javaGameCenterProject.Data.Abstract.UserDbService;
import javaGameCenterProject.Entities.Gamer;

public class GamerManager extends BaseUserManager{
	
	UserDbService _userDb;
	GamerDbService _gamerDb;
	UserValidationService _userValidationService;
	
	//public GamerManager(UserDbService userDb, GamerDbService gamerDb, UserValidationService userValidationService) {
	public GamerManager(ServiceFactory serviceFactory) {
		super(serviceFactory.createUserDbService());
		_gamerDb = serviceFactory.createGamerDbService();
		_userValidationService = serviceFactory.createUserValidationService();
	}

	public int register(Gamer gamer) {
		if(_userValidationService.Validate(gamer)) {
			//User user = new User(gamer.getRegisterDate());
			int userId = add(gamer);
			if(userId != 0) {
				gamer.setUserId(userId);
				int result = _gamerDb.add(gamer);
				
				if (result > 0) {
					System.out.println("Oyuncu kaydý baþarýyla gerçekleþtirildi: " + gamer.getFirstName() + " " + gamer.getLastName());
				}
				return gamer.getId();
			}
		}else {
			System.out.println("Kimlik doðrulamasý baþarýsýz: " + gamer.getFirstName() + " " + gamer.getLastName());
		}
		
		return 0;
	}

	public void update(Gamer gamer) {
		boolean result = _gamerDb.update(gamer);
		if (result) {
			super.update(gamer);
			System.out.println("Güncelleme baþarýlý");
		}else {
			System.out.println("Güncelleme baþarýsýz.");
		}
	}

	public void delete(Gamer gamer) {
		boolean result = _gamerDb.delete(gamer);
		if(result) {
			super.delete(gamer);
		}
	}

	public List<Gamer> getAll() {
		return _gamerDb.getAll();
	}


	public Gamer getById(int id) {
		return _gamerDb.getById(id);
	}
}
