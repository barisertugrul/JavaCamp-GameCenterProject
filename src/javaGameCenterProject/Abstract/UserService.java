package javaGameCenterProject.Abstract;

import java.util.List;

import javaGameCenterProject.Entities.User;

public interface UserService {
	int add(User user);
	void update(User user);
	void delete(User user);
	boolean Login(String email, String password);
	//List<User> getAll();
	//User getById(int id);
}
