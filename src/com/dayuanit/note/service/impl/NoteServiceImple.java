package com.dayuanit.note.service.impl;

import java.util.List;

import com.dayuanit.note.dao.NoteDao;
import com.dayuanit.note.domain.Note;
import com.dayuanit.note.service.NoteService;

public class NoteServiceImple implements NoteService {
	
	private final int currentUserId;
	
	private NoteDao noteDao = new NoteDao();
	
	public NoteServiceImple(int currentUserId) {
		this.currentUserId = currentUserId;
	}

	@Override
	public void writeNote(String title, String context, String weather) {
		
		if (null == title || "".equals(title)) {
			System.out.println("标题不能为空");
			return;
		}
		
		if (title.length() > 15) {
			System.out.println("标题不能超过15个字符");
			return;
		}
		
		
		if (null == context || "".equals(context)) {
			System.out.println("正文不能为空");
			return;
		}
		
		if (context.length() > 500) {
			System.out.println("正文不能超过500个字符");
			return;
		}
		
		//title不能重复
		List<Note> list = noteDao.listNote(title);
		if (!list.isEmpty()) {
			System.out.println("标题重复，请重新输入");
			return;
		}
		
		Note note = new Note();
		note.setContext(context);
		note.setTitle(title);
		note.setUserId(currentUserId);
		note.setWeather(weather);
		
		int rows = noteDao.addNote(note);
		if (1 != rows) {
			System.out.println("写日志失败");
		}
	}

	@Override
	public void modifyNote(int noteId, String title, String context, String weather) {
		Note note = noteDao.getNote(noteId);
		if (null == note) {
			System.out.println("日志不存在");
			return;
		}
		
		if (currentUserId != note.getUserId()) {
			System.out.println("日志不属于你");
			return;
		}
		
		note.setContext(context);
		note.setTitle(title);
		note.setWeather(weather);
		
		int rows = noteDao.modifyNote(note);
		if (1 != rows) {
			System.out.println("更新日志失败");
		}
	}

	@Override
	public void deleteNote(int noteId) {
		Note note = noteDao.getNote(noteId);
		if (null == note) {
			System.out.println("日志不存在");
			return;
		}
		
		if (currentUserId != note.getUserId()) {
			System.out.println("你无权操作");
			return;
		}
		
		int rows = noteDao.deleteNote(noteId);
		if (1 != rows) {
			System.out.println("删除失败");
		}
	}

}
