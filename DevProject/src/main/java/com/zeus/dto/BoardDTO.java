package com.zeus.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
}
