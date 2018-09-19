package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="friends_table")
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="friend_id")
	private int userId;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Users fuser;
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friends(int userId, Users fuser) {
		super();
		this.userId = userId;
		this.fuser = fuser;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Users getFUser() {
		return fuser;
	}
	public void setFUser(Users fuser) {
		this.fuser = fuser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fuser == null) ? 0 : fuser.hashCode());
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friends other = (Friends) obj;
		if (fuser == null) {
			if (other.fuser != null)
				return false;
		} else if (!fuser.equals(other.fuser))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Friends [userId=" + userId + ", fuser=" + fuser + "]";
	}
	
	
	
}
