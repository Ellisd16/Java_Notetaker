package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.service.UserService;

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
		
		
}
