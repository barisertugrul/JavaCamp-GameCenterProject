package javaGameCenterProject.Data.Concrete;

import java.util.List;

import javaGameCenterProject.Data.Database;
import javaGameCenterProject.Data.Abstract.GameDbService;
import javaGameCenterProject.Entities.Game;

public class GameDbManager implements GameDbService {

	@Override
	public int add(Game game) {
		List<Game> games = Database.getGames();
		int lastId = Database.getGameId();
		lastId++;
		game.setId(lastId);
		if(games.add(game)) {
			Database.setGameId(lastId);
			return lastId;
		}
		
		lastId--;
		return 0;
	}

	@Override
	public boolean update(Game game) {
		List<Game> games = Database.getGames();
		for (Game gameItem : games) {
			if (gameItem.getId() == game.getId()) {
				int index = games.indexOf(gameItem);
				games.set(index, game);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Game game) {
		List<Game> games = Database.getGames();
		games.remove(game);
		return true;
	}

	@Override
	public List<Game> getAll() {
		return Database.getGames();
	}

	@Override
	public Game getById(int id) {
		List<Game> games = Database.getGames();
		for (Game gameItem : games) {
			if (gameItem.getId() == id) {
				return gameItem;
			}
		}
		return null;
	}

}
