package com.company.security.other;

import java.util.List;
import java.util.Optional;




public interface UserService {
	public void createUser(User user);
	public List<User> getUser();
	public User findById(String name);
	public User update(User user, long l);
	public void deleteUserById(long id);
	public User updatePartially(User user, String name);
	public Optional<User> findById(long id);
}
