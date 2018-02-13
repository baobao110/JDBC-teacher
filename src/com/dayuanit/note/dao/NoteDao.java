package com.dayuanit.note.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dayuanit.note.db.DataBase;
import com.dayuanit.note.domain.Note;

public class NoteDao {
	
	public int addNote(Note note) {
		String sql = "INSERT into note(title, weather,context, create_time, user_id) value('" + note.getTitle() 
		+ "' , '"+note.getWeather()+"', '"+note.getContext()+"', now(), "+note.getUserId()+");";
		
		return DataBase.update(sql);
	}
	
	public int deleteNote(int id) {
		String sql = "delete from note where id=" + id + ";";
		return DataBase.update(sql);
	}
	
	public void modifyNote(int id, String title) {
		String sql = "update note set title='"+title+"' WHERE id="+id+";";
		DataBase.update(sql);
	}
	
	public void modifyNoteContext(int id, String context) {
		String sql = "update note set context='"+context+"' WHERE id="+id+";";
		DataBase.update(sql);
	}
	
	
	public int modifyNote(Note note) {
		String sql = "update note set title='"+note.getTitle()+"', weather='"+note.getWeather()+"', context='"+note.getContext()+"' WHERE id="+note.getId()+";";
		return DataBase.update(sql);
	}
	
	public Note getNote(int id) {
		String sql = "SELECT id, title, weather, context, user_id from note where id="+id+";";
		ResultSet rs = DataBase.query(sql);
		
		try {
			while (rs.next()) {
				int noteId = rs.getInt("id");
				String title = rs.getString("title");
				String weather = rs.getString("weather");
				String context = rs.getString("context");
				int userId = rs.getInt("user_id");
				
				Note note = new Note();
				note.setContext(context);
				note.setId(noteId);
				note.setTitle(title);
				note.setWeather(weather);
				note.setUserId(userId);
				
				return note;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Note> listNote(String title) {
		String sql = "SELECT id, title, weather, context from note where title like '%"+title+"%';";
		
		ResultSet rs = DataBase.query(sql);
		
		List<Note> list = new ArrayList<Note>();
		
		try {
			while (rs.next()) {
				int noteId = rs.getInt("id");
				String noteTile = rs.getString("title");
				String weather = rs.getString("weather");
				String context = rs.getString("context");
				
				Note note = new Note();
				note.setContext(context);
				note.setId(noteId);
				note.setTitle(noteTile);
				note.setWeather(weather);
				
				list.add(note);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<Note> listNoteNoLike(String title) {
		String sql = "SELECT id, title, weather, context from note where title='"+title+"';";
		
		ResultSet rs = DataBase.query(sql);
		
		List<Note> list = new ArrayList<Note>();
		
		try {
			while (rs.next()) {
				int noteId = rs.getInt("id");
				String noteTile = rs.getString("title");
				String weather = rs.getString("weather");
				String context = rs.getString("context");
				
				Note note = new Note();
				note.setContext(context);
				note.setId(noteId);
				note.setTitle(noteTile);
				note.setWeather(weather);
				
				list.add(note);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		NoteDao dao = new NoteDao();
		
		Note note = dao.getNote(5);
		
		dao.modifyNote(note);
		
		List<Note> list = dao.listNote("»À");
		for (Note n : list) {
			System.out.println(n);
		}
		
		
	}

}
