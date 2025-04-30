package com.myhome.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myhome.dto.BoardDto;
import com.myhome.service.BoardService;

import jakarta.annotation.Resource;

/**
 * Controller 어노테이션
 * 웹 주소와의 매핑의 역할을 하게끔 하는 세팅
 */
@Controller
public class BoardController {
	
	@Resource
	BoardService boardService;
	
	@GetMapping("b/write")
	public ModelAndView boardWrite(ModelAndView mav) {
		mav.setViewName("board/boardWrite");
		return mav;
	}
	
	@PostMapping("b/insert")
	public String insertBoard(BoardDto dto) throws Exception {
		
		int result = boardService.insertBoard(dto);
		if( result == 1 ) {
			System.out.println("== 저장 완료 ==");
		} else {
			System.out.println("== 저장 실패 ==");
		}
		return "";
		//return "redirect:list";
	}
	
	@PostMapping("b/update")
	public String updateBoard(BoardDto dto) throws Exception {
		
		int result = boardService.updateBoard(dto);
		if( result == 1 ) {
			System.out.println("== 수정 완료 ==");
		} else {
			System.out.println("== 수정 실패 ==");
		}
		return "redirect:list";
	}
	
	@GetMapping("b/delete/{seqid}")
	public String deleteBoard(@PathVariable int seqid) 
										throws Exception {
		// 서비스 실행
		int cnt = boardService.deleteBoard(seqid);
		if( cnt == 1 ) {
			System.out.println("== 삭제 완료 ==");
		} else {
			System.out.println("== 삭제 실패 ==");
		}
		
		return "redirect:/b/list";
	}
	
	
	@GetMapping("b/list")
	public String selectBoardList(BoardDto dto, ModelMap model) throws Exception{	
		
		List<?> list = boardService.selectBoardList(dto);
		
		// JSP의 출력을 위한 세팅
		model.addAttribute("datalist",list); // (변수명,데이터값)
		System.out.println("list : " + list);
		
		return "board/boardList";
	}
	
	@GetMapping("b/detail/{seqid}")
	public String selectBoardDetail(@PathVariable int seqid, ModelMap model) 
												throws Exception {
		// 조회수 증가
		boardService.updateBoardHits(seqid);
		
		// 관련 서비스 실행
		BoardDto dto = boardService.selectBoardDetail(seqid);
		model.addAttribute("dto",dto);
		
		return "board/boardDetail";
	}
	
	@GetMapping("b/modify/{seqid}") 
	// @PathVariable :: 외부에서 유입된 데이터를 사용가능한 매개변수로 변환 처리하는 어노테이션
	public String selectBoardModify(@PathVariable int seqid, ModelMap model) 
												throws Exception {
		
		// 관련 서비스 실행
		BoardDto dto = boardService.selectBoardDetail(seqid);
		model.addAttribute("dto",dto); // (변수명,데이터)

		return "board/boardModify";
	}
}






