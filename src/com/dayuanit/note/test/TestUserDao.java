package com.dayuanit.note.test;

import com.dayuanit.note.dao.UserDao;
import com.dayuanit.note.domain.User;

public class TestUserDao {
	
	private static final UserDao userDao = new UserDao();
	
	public static void main(String[] args) {
		testAddUsre();
		
//		testModifyPassword();
	}

	public static void testAddUsre() {
		User user = new User();
		user.setPassword("111111");
		user.setUsername("jack");
		int rows = userDao.addUser(user);
		System.out.println(rows == 1 ? "×¢²á³É¹¦" : "×¢²áÊ§°Ü" );
	}
	
	public static void testModifyPassword() {
		User user = userDao.getUser("tom");
		user.setPassword("2222222");
		int rows = userDao.modifyPassword(user);
		System.out.println(rows == 1 ? "ÐÞ¸Ä³É¹¦" : "ÐÞ¸ÄÊ§°Ü" );
	}
}
