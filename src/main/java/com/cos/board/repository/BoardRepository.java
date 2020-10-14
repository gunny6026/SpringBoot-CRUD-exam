package com.cos.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.board.model.Board;

//데이터 베이스 관련 로직을 다 만들었다. repository랑 dao를 다 만들었다...???
//자동 IOC 등록 됨.
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	
	//Select * from board where title =?
	Board findByTitle(String title);

	//select * from board where content = ?
	Board findByContent(String content);
	
	//select * from board where title =? and content =?
	
	Board findByTitleAndContent(String title, String content);
}
