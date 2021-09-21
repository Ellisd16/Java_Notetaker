package com.revature.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.revature.beans.Note;

@Table("notes")
public class NoteDTO {
	
	@PrimaryKey("title")
	@Column
	private String title;
	@Column("noteId")
	private UUID noteId;
	@Column("description")
	private String description;
	@Column("date")
	private LocalDate date;
	
	public NoteDTO() {
		super();
		
	}
	public NoteDTO(Note note){
		this.title = note.getTitle();
		this.noteId = note.getNoteId();
		this.description = note.getDescription();
		this.date = note.getDate();
	}
	
	public Note getNote() {
		Note n = new Note();
		n.setTitle(this.title);
		n.setDate(this.date);
		n.setNoteId(this.noteId);
		n.setDescription(this.description);
		
		return n;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UUID getNoteId() {
		return noteId;
	}
	public void setNoteId(UUID noteId) {
		this.noteId = noteId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
		NoteDTO other = (NoteDTO) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(noteId, other.noteId) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "NoteDTO [title=" + title + ", noteId=" + noteId + ", description=" + description + ", date=" + date
				+ "]";
	}
	

}
