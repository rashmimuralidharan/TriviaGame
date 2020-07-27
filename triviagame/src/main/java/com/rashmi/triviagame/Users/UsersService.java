package com.rashmi.triviagame.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		usersRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public User getUser(String id) {
		return usersRepository.findOne(id);
	}

	public void addUser(User user) {
		usersRepository.save(user);
		
	}

	public void updateUser(String id, User user) {
		usersRepository.save(user);
		}
		
	
	public void deleteUser(String id) {
		usersRepository.delete(id);
	}

}
