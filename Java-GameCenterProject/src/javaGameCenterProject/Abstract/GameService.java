package javaGameCenterProject.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Game;

public interface GameService {
	void add(Game game);
	void update(Game game);
	void delete(Game game);
	List<Game> getAll();
	Game getById(int id);
}
