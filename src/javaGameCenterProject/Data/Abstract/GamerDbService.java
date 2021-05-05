package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.Gamer;

public interface GamerDbService {
	int add(Gamer gamer);
	boolean update(Gamer gamer);
	boolean delete(Gamer gamer);
	List<Gamer> getAll();
	Gamer getById(int id);
	Gamer getByUserId(int userId);
}
