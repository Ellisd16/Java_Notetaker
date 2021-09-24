package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import com.revature.beans.User;
import com.revature.service.UserService;
import com.revature.util.WebSessionAttributes;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

		private User loggedUser;
		private UserService userSer;
		
		@Autowired
		public UserController(UserService userSer) {
			this.userSer = userSer;
		}
		
		//user login
		@PostMapping("/login")
		public Mono<ResponseEntity<User>> login(@RequestBody User user, WebSession session){
			return userSer.login(user.getUsername(), user.getPassword()).map(u -> {
				session.getAttributes().put(WebSessionAttributes.LOGGED_USER, u);
				return ResponseEntity.ok(u);
			}).switchIfEmpty(Mono.just(ResponseEntity.status(401).build()));
		}
		
		@DeleteMapping("/logout")
		public ResponseEntity<Void> logout(WebSession session){
			session.invalidate();
			return ResponseEntity.noContent().build();
		}
		@PutMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
		public Mono<ResponseEntity<User>> register(@RequestBody User user, WebSession session){
			return userSer.register(user).map(u -> {
				session.getAttributes().put(WebSessionAttributes.LOGGED_USER, u);
				return ResponseEntity.ok(u);
			}).switchIfEmpty(Mono.just(ResponseEntity.status(404).build()));
					}
		
		
		
}
