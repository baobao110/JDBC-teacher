package com.dayuanit.note.test;

import com.dayuanit.note.dao.NoteDao;
import com.dayuanit.note.domain.Note;

public class TestNoteDao {
	
	private static final NoteDao noteDao = new NoteDao();
	
	public static void main(String[] args) {
		testAddNote();
	}
	
	public static void testAddNote() {
		Note note = new Note();
		note.setContext("xxxx");
		note.setTitle("xxx2233");
		note.setUserId(3);
		note.setWeather("ÇçÌì");
		
		noteDao.addNote(note);
	}

}
