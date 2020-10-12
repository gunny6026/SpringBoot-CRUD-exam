package com.cos.board;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.cos.board.model.Board;

public class BoardTest {

	
	@Test
	public void lombokTest() {
		System.out.println("=======================================================================");
		//1.Board 모델
		Board board1 = new Board();
		board1.setTitle("제목");
		System.out.println(board1);
		
		Board board2 = new Board(
				2,
				"제목2",
				"내용2",
				0,
				Timestamp.valueOf(LocalDateTime.now())
				
				);
		

		System.out.println(board2);
		Board board3 = Board.builder().title("제목3").conetent("내용3").build();
		
		System.out.println(board3);
		
		System.out.println("=============================================================================");
	
	}

}
