package com.revature.data;

import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.revature.dto.NoteDTO;

import reactor.core.publisher.Mono;

public interface NoteDAO extends ReactiveCassandraRepository<NoteDTO, String>{
	
	@Query("Select * from Note_taker.notes where title = ?")
	Mono<NoteDTO> findbyTitle(String title);
	
	Mono<NoteDTO> findbyUUID(UUID noteId);
}
