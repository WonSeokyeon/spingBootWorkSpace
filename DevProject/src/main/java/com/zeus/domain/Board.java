package com.zeus.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = {"regDate","count"})
public class Board  {

	// 멤버변수
	@NonNull
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int count;
}
