package javaGameCenterProject.Concrete;

import java.util.List;

import javaGameCenterProject.Abstract.GameService;
import javaGameCenterProject.Data.Abstract.GameDbService;
import javaGameCenterProject.Entities.Game;

public class GameManager implements GameService {
	
	GameDbService _gamedb;

	public GameManager(GameDbService gamedb) {
		super();
		this._gamedb = gamedb;
	}

	@Override
	public void add(Game game) {
		int lastId = _gamedb.add(game);
		if (lastId > 0) {
			System.out.println(game.getName() + " adlý oyun sisteme eklendi.");
		}else {
			System.out.println("Üzgünüz, " + game.getName() + " adlý oyun sisteme eklenemedi.");
		}
		
		
	}

	@Override
	public void update(Game game) {
		_gamedb.update(game);
		
	}

	@Override
	public void delete(Game game) {
		_gamedb.delete(game);
		
	}

	@Override
	public List<Game> getAll() {
		return _gamedb.getAll();
	}

	@Override
	public Game getById(int id) {
		return _gamedb.getById(id);
	}

}
