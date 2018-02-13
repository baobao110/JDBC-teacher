package com.dayuanit.note.domain;

import java.util.Date;

public class Note {
	
	private int id;
	private String title;
	private String weather;
	private String context;
	private Date createTime;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder sx = new StringBuilder();
		sx.append("{id:").append(id).append(",")
			.append("weather:").append(weather).append(",")
			.append("context:").append(context).append(",")
			.append("title:").append(title).append(",")
			.append("userId:").append(userId).append("}");
		
		return sx.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
