package com.revature.data;



import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.revature.dto.UserDTO;

import reactor.core.publisher.Mono;

public interface UserDAO extends ReactiveCassandraRepository<UserDTO, String>{

	@Query("Select * from Note_taker.users where username = ?")
	Mono<UserDTO> findbyUsername(String username);
	
	
}
