package com.dayuanit.note.test;

import com.dayuanit.note.service.NoteService;
import com.dayuanit.note.service.impl.NoteServiceImple;

public class TestNoteService {
	
	private static final NoteService noteService = new NoteServiceImple(2);
	
	public static void main(String[] args) {
//		testWriteNote();
		
//		testModifyNote();
		
		testDeleteNote();
	}
	
	public static void testWriteNote() {
		noteService.writeNote("abc", "你好", "请听听");
	}
	
	public static void testModifyNote() {
		noteService.modifyNote(107, "world hello", "好人啊", "天气");
	}
	
	public static void testDeleteNote() {
		noteService.deleteNote(107);
	}
	

}
