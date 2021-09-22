package com.revature.service;

import com.revature.beans.User;

import reactor.core.publisher.Mono;

public interface UserService {

	Mono<User> login(String username, String password);
	
	Mono<User> register(User user);
	
	Mono<User> viewUser(User user, String empName);
}
