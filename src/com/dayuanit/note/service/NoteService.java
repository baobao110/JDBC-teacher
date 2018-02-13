package com.dayuanit.note.service;

public interface NoteService {
	
	void writeNote(String title, String context, String weather);
	
	void modifyNote(int noteId, String title, String context, String weather);
	
	void deleteNote(int noteId);

}
