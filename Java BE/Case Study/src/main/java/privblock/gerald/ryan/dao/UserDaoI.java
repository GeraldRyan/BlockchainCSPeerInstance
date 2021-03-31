package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.User;

public interface UserDaoI {
	public void addUser(User user);
	public User getUser(int id);
	public void updateUser(User user);
	public void removeUser(int id);
	public List<User> getAllUsers();

}
