package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.dto.UserDTO;

import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService{
	private UserDAO userdao;
	
	@Autowired
	public UserServiceImpl(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	@Override
	public Mono<User> login(String username, String password) {
		Mono<UserDTO> userDTO = userdao.findbyUsername(username);
		return userDTO.filter(dto -> dto.getPassword().equals(password)).map(dto-> {
			return dto.getUser();
		});
	}

	@Override
	public Mono<User> register(User user) {
		return userdao.save(new UserDTO(user)).map(u -> u.getUser());
	}

	@Override
	public Mono<User> viewUser(User user, String empName) {
		return userdao.findbyUsername(empName).map(u -> 
			u.getUser()
		);
	}

}
