package com.dayuanit.note.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DataBase {
	
	private static Connection conn;
	
	static {
		try {
			
			Properties pro = new Properties();
			pro.load(DataBase.class.getResourceAsStream("/jdbc.properties"));
			
			Class.forName(pro.getProperty("jdbc.driver"));
			
			conn = DriverManager.getConnection(pro.getProperty("jdbc.url"), pro.getProperty("jdbc.username"), pro.getProperty("jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int update(String sql) {
		try {
			Statement st = conn.createStatement();
			return st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static ResultSet query(String sql) {
		
		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
