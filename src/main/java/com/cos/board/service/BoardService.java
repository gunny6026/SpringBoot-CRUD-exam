package com.cos.board.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
		
	}
	
	
	public List<Board> 글목록보기() {
		 return  boardRepository.findAll();
	}
	
	@Transactional
	public Board 글상세보기(int id ) throws Exception {
		 Board board = boardRepository.findById(id).
				orElseThrow( ()->new RuntimeException("ID값이 잘 못 들어왔습니다."));
	
		 //조회수 증가 = 더티체킹
		 
		 
		 
		 
		 return board;
		 
	}

			
	@Transactional		
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
			
	
	@Transactional
	public void 글수정하기(int id , BoardSaveRequestDto dto) {
		//더티 체킹
		Board boardEntity = boardRepository.findById(id).
				orElseThrow( ()->new RuntimeException("ID값이 잘 못 들어왔습니다."));
		
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
	}
		
	}
	
	
