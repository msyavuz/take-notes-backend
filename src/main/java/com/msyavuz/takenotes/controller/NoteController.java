package com.msyavuz.takenotes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msyavuz.takenotes.dto.NoteCreationDTO;
import com.msyavuz.takenotes.dto.NoteUpdateDTO;
import com.msyavuz.takenotes.entity.Note;
import com.msyavuz.takenotes.service.impl.NoteServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

	private final NoteServiceImpl noteServiceImpl;

	@GetMapping()
	public ResponseEntity<List<Note>> getNotes() {

		return new ResponseEntity<>(this.noteServiceImpl.getAll(), HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<Boolean> createNote(@RequestBody NoteCreationDTO note) {

		return new ResponseEntity<>(this.noteServiceImpl.newNote(note.getTitle(), note.getContent()), HttpStatus.OK);

	}

	@PutMapping()
	public ResponseEntity<Boolean> updateNote(@RequestBody NoteUpdateDTO note) {

		return new ResponseEntity<>(
				this.noteServiceImpl.editById(note.getId(), note.getTitle(), note.getContent(), note.isChecked()),
				HttpStatus.OK);

	}

	@DeleteMapping()
	public ResponseEntity<String> deleteNote(@RequestBody int id) {

		this.noteServiceImpl.deleteById(id);
		return new ResponseEntity<>("Done", HttpStatus.OK);

	}

}
