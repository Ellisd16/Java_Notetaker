package com.revature.beans;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Note {
	
	private UUID noteId;
	private LocalDate date;
	private String title;
	private String description;
	
	public Note() {
		super();
		this.noteId = UUID.randomUUID();
	}

	public Note(LocalDate date, String title, String description) {
		this();
		
		this.date = date;
		this.title = title;
		this.description = description;
	}
	

	public UUID getNoteId() {
		return noteId;
	}

	public void setNoteId(UUID noteId) {
		this.noteId = noteId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, noteId, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(noteId, other.noteId) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", date=" + date + ", title=" + title + ", description=" + description + "]";
	}

	
	
}
