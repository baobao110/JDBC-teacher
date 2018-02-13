package com.dayuanit.note.domain;

import java.util.Date;

public class User {
	
	private int id;
	private String username;
	private String password;
	private Date createTime;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		.append("id:").append(id).append(",")
		.append("username:").append(username).append(",")
		.append("password:").append(password)
		.append("}");
		return super.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
