package javaGameCenterProject.Data.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.User;

public interface UserDbService {
	int add(User user);
	boolean update(User user);
	boolean delete(User user);
	List<User> getAll();
	User getById(int id);
}
