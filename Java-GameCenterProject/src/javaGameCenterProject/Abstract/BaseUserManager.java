package javaGameCenterProject.Abstract;

import java.util.List;

import javaGameCenterProject.Data.Abstract.UserDbService;
import javaGameCenterProject.Entities.User;

public class BaseUserManager implements UserService {
	
	UserDbService _userDb;

	public BaseUserManager(UserDbService userDb) {
		this._userDb = userDb;
	}
	
	@Override
	public int add(User user) {
		return _userDb.add(user);
	}

	@Override
	public void update(User user) {
		_userDb.update(user);
	}

	@Override
	public void delete(User user) {
		_userDb.delete(user);
		
	}

	public List<User> getAllUsers() {
		return _userDb.getAll();
	}


	public User getUserById(int id) {
		return _userDb.getById(id);
	}

	@Override
	public boolean Login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
