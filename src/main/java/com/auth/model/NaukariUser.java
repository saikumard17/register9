package com.auth.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "naukari_creds")
public class NaukariUser {
	@Id
	private long id;
	private String username;
	private String password;
	private File file;
	
	public NaukariUser(long id, String username, String password, File file) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.file = file;
	}
	public NaukariUser() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "NaukariCredentials [id=" + id + ", username=" + username + ", password=" + password + ", file=" + file
				+ "]";
	}
	

}
