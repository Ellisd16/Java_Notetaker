package com.revature.service;

import com.revature.beans.Note;
import com.revature.beans.User;
import com.revature.data.NoteDAO;
import com.revature.data.UserDAO;
import com.revature.dto.NoteDTO;
import com.revature.dto.UserDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class NoteServiceImpl implements NoteService{
	private NoteDTO noteDto;
	private UserDTO userDto;
	private NoteDAO notedao;
	private UserDAO userdao;
	
	public NoteServiceImpl(NoteDTO noteDto, UserDTO userDto,  NoteDAO notedao, UserDAO userdao ) {
		this.noteDto = noteDto;
		this.userDto = userDto;
		this.notedao = notedao;
		this.userdao = userdao;
	}
	
	@Override
	public Flux<Note> getUserNotes(User user) {
		return Flux.fromStream(user.getNotes().stream()).flatMap(noteId -> notedao.findbyUUID(noteId)).map(dto -> dto.getNote());
	}

	@Override
	public Mono<Note> getUserNoteByTitle(User user, String title) {
		return Mono.from(notedao.findbyTitle(title).map(dto -> dto.getNote()));
	}

	@Override
	public Mono<Note> addANote(Note newNote) {
		return notedao.save(new NoteDTO(newNote)).map(n -> n.getNote());
	}

	@Override
	public Mono<Note> editANote(String title, String description) {
		return notedao.findbyTitle(title).flatMap(dto -> {
			dto.setDescription(description);
			return notedao.save(dto);
		}).map(dto -> dto.getNote());
		
		
	}

}
