package com.msyavuz.takenotes.dto;

import lombok.Data;

@Data
public class NoteUpdateDTO {

	private int id;
	private String title;
	private String content;
	private boolean checked;
}
