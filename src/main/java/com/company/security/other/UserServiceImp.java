package com.company.security.other;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {

		userRepository.save(user);
	}

	public List<User> getUser() {

		return (List<User>) userRepository.findAll();
	}

	public User findById(String name) {

		return userRepository.findByName(name);
	}

	public Optional<User> findById(long id) {

		return userRepository.findById(id);
	}

	public User update(User user, long l) {

		return userRepository.save(user);
	}

	public void deleteUserById(long id) {

		userRepository.deleteById(id);
	}

	public User updatePartially(User user, String name) {
		
		User usr = findById(name);
		usr.setCountry(user.getCountry());
		return userRepository.save(usr);
	}

}
