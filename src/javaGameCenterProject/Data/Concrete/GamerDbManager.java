package javaGameCenterProject.Data.Concrete;

import java.util.List;

import javaGameCenterProject.Data.Database;
import javaGameCenterProject.Data.Abstract.GamerDbService;
import javaGameCenterProject.Entities.Gamer;

public class GamerDbManager implements GamerDbService {

	@Override
	public int add(Gamer gamer) {
		List<Gamer> gamers = Database.getGamers();
		int lastId = Database.getGamerId();
		lastId++;
		gamer.setId(lastId);
		if(gamers.add(gamer)) {
			Database.setGamerId(lastId);
			return lastId;
		}
		
		lastId--;
		return 0;
	}

	@Override
	public boolean update(Gamer gamer) {
		List<Gamer> gamers = Database.getGamers();
		for (Gamer gamerItem : gamers) {
			if (gamerItem.getId() == gamer.getId()) {
				int index = gamers.indexOf(gamerItem);
				gamers.set(index, gamer);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Gamer gamer) {
		List<Gamer> gamers = Database.getGamers();
		gamers.remove(gamer);
		return true;
	}

	@Override
	public List<Gamer> getAll() {
		return Database.getGamers();
	}

	@Override
	public Gamer getById(int id) {
		List<Gamer> gamers = Database.getGamers();
		for (Gamer gamerItem : gamers) {
			if (gamerItem.getId() == id) {
				return gamerItem;
			}
		}
		return null;
	}

	@Override
	public Gamer getByUserId(int userId) {
		List<Gamer> gamers = Database.getGamers();
		for (Gamer gamerItem : gamers) {
			if (gamerItem.getUserId() == userId) {
				return gamerItem;
			}
		}
		return null;
	}

}
