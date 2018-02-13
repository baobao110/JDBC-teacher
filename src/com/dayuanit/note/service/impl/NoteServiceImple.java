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
			System.out.println("���ⲻ��Ϊ��");
			return;
		}
		
		if (title.length() > 15) {
			System.out.println("���ⲻ�ܳ���15���ַ�");
			return;
		}
		
		
		if (null == context || "".equals(context)) {
			System.out.println("���Ĳ���Ϊ��");
			return;
		}
		
		if (context.length() > 500) {
			System.out.println("���Ĳ��ܳ���500���ַ�");
			return;
		}
		
		//title�����ظ�
		List<Note> list = noteDao.listNote(title);
		if (!list.isEmpty()) {
			System.out.println("�����ظ�������������");
			return;
		}
		
		Note note = new Note();
		note.setContext(context);
		note.setTitle(title);
		note.setUserId(currentUserId);
		note.setWeather(weather);
		
		int rows = noteDao.addNote(note);
		if (1 != rows) {
			System.out.println("д��־ʧ��");
		}
	}

	@Override
	public void modifyNote(int noteId, String title, String context, String weather) {
		Note note = noteDao.getNote(noteId);
		if (null == note) {
			System.out.println("��־������");
			return;
		}
		
		if (currentUserId != note.getUserId()) {
			System.out.println("��־��������");
			return;
		}
		
		note.setContext(context);
		note.setTitle(title);
		note.setWeather(weather);
		
		int rows = noteDao.modifyNote(note);
		if (1 != rows) {
			System.out.println("������־ʧ��");
		}
	}

	@Override
	public void deleteNote(int noteId) {
		Note note = noteDao.getNote(noteId);
		if (null == note) {
			System.out.println("��־������");
			return;
		}
		
		if (currentUserId != note.getUserId()) {
			System.out.println("����Ȩ����");
			return;
		}
		
		int rows = noteDao.deleteNote(noteId);
		if (1 != rows) {
			System.out.println("ɾ��ʧ��");
		}
	}

}
