package com.revature.service;

import com.revature.beans.Note;
import com.revature.beans.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoteService {

	Flux<Note> getUserNotes(User user);
	
	Mono<Note> getUserNoteByTitle(User user, String title);
	
	Mono<Note> addANote(Note newNote);
	
	Mono<Note> editANote (String title, String description);
	
}
