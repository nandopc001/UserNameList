/**
 * 
 */
package com.intertec.listusername.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertec.listusername.model.User;
import com.intertec.listusername.repository.UserRepository;
import com.intertec.listusername.service.UserService;

/**
 * @author nandopc001
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.intertec.listusername.service.UserService#addUser(com.intertec.
	 * listusername.model.User)
	 */
	@Override
	public User addUser(String name) {
		User user = new User();
		user.setName(name);
		user = userRepository.save(user);
		
		return user;
	}
}
