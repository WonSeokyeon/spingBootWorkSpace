package com.zeus.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoradTest {

	// @Test
	public void test1() {
		Board board = new Board();
		board.setBoardNo(10);
		board.setTitle("wsy");
		System.out.printf("%s  %d \n", board.getTitle(), board.getBoardNo());
	}

	@Test
	public void test2() {
		Board board = new Board();
		System.out.printf("%s\n", board);
	}
}
