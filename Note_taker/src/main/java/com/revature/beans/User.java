package com.revature.beans;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
	
	private UUID userId;
	private String username;
	private String password;
	private UserType type;
	private List<UUID> notes;
	
	public User() {
		super();
		this.userId = UUID.randomUUID();
	}
	public User(String username, String password, UserType type) {
		this();
		this.username = username;
		this.password = password;
		this.type = UserType.User;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public List<UUID> getNotes() {
		return notes;
	}
	public void setNotes(List<UUID> notes) {
		this.notes = notes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(notes, password, type, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(notes, other.notes) && Objects.equals(password, other.password) && type == other.type
				&& Objects.equals(userId, other.userId) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", notes=" + notes + "]";
	}
	
}
