package javaGameCenterProject.Data.Concrete;

import java.time.LocalDate;
import java.util.List;

import javaGameCenterProject.Data.Database;
import javaGameCenterProject.Data.Abstract.UserDbService;
import javaGameCenterProject.Entities.Gamer;
import javaGameCenterProject.Entities.User;

public class UserDbManager implements UserDbService {

	@Override
	public int add(User user) {
		List<User> users = Database.getUsers();
		int lastId = Database.getUserId();
		lastId++;
		user.setId(lastId);
		if(user.getRegisterDate() == null) {
			user.setRegisterDate(LocalDate.now());
		}
		if(users.add(user)) {
			Database.setUserId(lastId);
			return lastId;
		}
		
		lastId--;
		return 0;
	}

	@Override
	public boolean update(User user) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getId() == user.getId()) {
				int index = users.indexOf(userItem);
				users.set(index, user);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		List<User> users = Database.getUsers();
		users.remove(user);
		return true;
	}

	@Override
	public List<User> getAll() {
		return Database.getUsers();
	}

	@Override
	public User getById(int id) {
		List<User> users = Database.getUsers();
		for (User userItem : users) {
			if (userItem.getId() == id) {
				return userItem;
			}
		}
		return null;
	}

}
