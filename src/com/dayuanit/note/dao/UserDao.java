package com.dayuanit.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dayuanit.note.db.DataBase;
import com.dayuanit.note.domain.User;

public class UserDao {
	
	public int addUser(User user) {
		String sql = "INSERT INTO user(username, password, create_time) value('"+user.getUsername()+"', '"+user.getPassword()+"', now());";
		return DataBase.update(sql);
	}
	
	public int modifyPassword(User user) {
		String sql = "UPDATE user set PASSWORD='"+user.getPassword()+"' WHERE id="+user.getId()+";";
		return DataBase.update(sql);
	}
	
	public User getUser(String username) {
		String sql = "SELECT id, username, password from user where username='"+username+"';";
		ResultSet rs = DataBase.query(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
