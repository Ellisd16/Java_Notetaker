package com.revature.data;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.revature.dto.NoteDTO;

public interface NoteDAO extends ReactiveCassandraRepository<NoteDTO, String>{
//	@Query("Select * from notes")
}
