package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Game;

public interface GameDbService {
	int add(Game game);
	boolean update(Game game);
	boolean delete(Game game);
	List<Game> getAll();
	Game getById(int id);
}
