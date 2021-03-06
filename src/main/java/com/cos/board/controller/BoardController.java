package com.cos.board.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;
import com.cos.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// http://localhost:8000/saveForm
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm"; // <- 파일임 문자가 아니라~

	}

	@GetMapping("/updateForm/{id}")
	public String updateFrom(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("board", boardService.글상세보기(id));

		return "updateForm";
	}

	@PostMapping("/save")
	@ResponseBody
	public String save(BoardSaveRequestDto dto) {
		boardService.글쓰기(dto);

		return "list";

	}

	// 스프링에서 Controller의 메서드의 파라미터 부분은 자동 DI가 됨.
	@GetMapping({ "", "/", "/list" })
	public String list(Model model,
			@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<Board> boards = boardService.글목록보기(pageable);
		System.out.println("크기 : " + boards.getContent().size());
		model.addAttribute("boards", boards);
		return "list";
	}

	@GetMapping("/list/test")
	@ResponseBody
	public Page<Board> listTest(@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {

		return boardService.글목록보기(pageable);
	}

	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) throws Exception {

		// Board board = boardRepository.findById(id).orElse(new Board());
		/*
		 * Board board = boardRepository.findById(id).orElseGet(new Supplier<Board>() {
		 * 
		 * @Override public Board get() {
		 * 
		 * System.out.println("못찾았다.... ㅠ "); return new Board(); } });
		 */

		model.addAttribute("board", boardService.글상세보기(id));

		return "detail";
	}

	@DeleteMapping("/board/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		boardService.글삭제하기(id);

		return "ok";
	}

	@PutMapping("/board/{id}")
	@ResponseBody // json 데이터 받을 때 RequestBody 써야함
	public String update(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) {
		System.out.println("ddddddd");
		boardService.글수정하기(id, dto);

		return "ok";
	}
}
