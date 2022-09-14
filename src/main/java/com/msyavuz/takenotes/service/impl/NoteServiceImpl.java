package com.msyavuz.takenotes.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msyavuz.takenotes.entity.Note;
import com.msyavuz.takenotes.repository.NoteRepo;
import com.msyavuz.takenotes.service.NoteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepo noteRepo;

	@Override
	public List<Note> getAll() {
		return this.noteRepo.findAll();
	}

	@Override
	public boolean newNote(String title, String content) {
		if (this.noteRepo.existsByTitle(title)) {
			return false;
		} else {
			Note newNote = new Note(0, title, content, LocalDateTime.now(), false, LocalDateTime.now());
			this.noteRepo.save(newNote);
			return true;
		}

	}

	@Override
	public boolean editById(int id, String title, String content, boolean checked) {
		Note currentNote = this.noteRepo.findById(id).get();
		if (currentNote != null) {
			this.noteRepo.save(new Note(currentNote.getId(), title, content, currentNote.getCreatedAt(), checked,
					LocalDateTime.now()));
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void deleteById(int id) {
		this.noteRepo.deleteById(id);
	}

}
