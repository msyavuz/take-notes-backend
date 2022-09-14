package com.msyavuz.takenotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msyavuz.takenotes.entity.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {

	public boolean existsByTitle(String title);

}
