package com.revature.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.revature.beans.User;
import com.revature.beans.UserType;

@Table("users")
public class UserDTO {
	
	@PrimaryKey("username")
	@Column
	private String username;
	@Column("userId")
	private UUID userId;
	@Column("password")
	private String password;
	@Column("UserType")
	private UserType type;
	@Column("notes")
	private List<UUID> notesId;
	
	
	public UserDTO() {
		super();
		this.type = UserType.User;
		this.notesId = new ArrayList<UUID>();
	}
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.type = user.getType();
	}
	public User getUser() {
		User u = new User();
		u.setUsername(this.username);
		u.setPassword(this.password);
		u.setType(this.type);
		u.setUserId(UUID.randomUUID());
		u.setNotes(this.notesId);
		
		return u;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
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
	public List<UUID> getNotesId() {
		return notesId;
	}
	public void setNotesId(List<UUID> notesId) {
		this.notesId = notesId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(notesId, password, type, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(notesId, other.notesId) && Objects.equals(password, other.password) && type == other.type
				&& Objects.equals(userId, other.userId) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", userId=" + userId + ", password=" + password + ", type=" + type
				+ ", notesId=" + notesId + "]";
	}
	
}
