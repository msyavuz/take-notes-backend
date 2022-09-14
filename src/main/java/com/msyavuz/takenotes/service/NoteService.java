package com.msyavuz.takenotes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msyavuz.takenotes.entity.Note;

@Service
public interface NoteService {

	public List<Note> getAll();

	public boolean newNote(String title, String content);

	public boolean editById(int id, String title, String content, boolean checked);

	public void deleteById(int id);

}
