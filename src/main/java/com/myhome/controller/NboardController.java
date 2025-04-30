package com.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.service.NboardService;

@Controller
public class NboardController {

	@Autowired
	NboardService nboardService;

	@GetMapping("nboardWrite")
	public String boardWrite() {
		return "board/nboardWrite";
	}
	
	@GetMapping("nboardModify/{seqid}")
	public String selectNboardModify(@PathVariable int seqid, ModelMap model) throws Exception {
		
		NboardDto dto = nboardService.selectNboardDetail(seqid);
		model.addAttribute("dto", dto);
		
		return "board/nboardModify";
	}
	
	@GetMapping("passWrite/{seqid}")
	public String passWrite(@PathVariable int seqid, ModelMap model) throws Exception {
		model.addAttribute("seqid", seqid);
		return "board/passWrite";
	}
	
	@PostMapping("nboardInsert") 
	// @ResponseBody :: return 값을 일반 jsp 경로가 아닌 일반 텍스트로 인식
	@ResponseBody
	public String insertNboard(NboardDto dto) throws Exception {
		
		String message = "ok";
		// 저장서비스 실행
		int result = nboardService.insertNboard(dto);
		if( result == 0 ) message = "fail";
	
		return message;
	}
	
	@PostMapping("nboardDelete") 
	@ResponseBody
	public String deleteNboard(NboardDto dto) throws Exception {
		
		String message = "1"; // 성공 번호 값
		// 암호확인 서비스 (seqid,pass)
		int cnt = nboardService.selectNboardPassCheck(dto);
		if( cnt == 0 ) {
			message = "2";
		} else {
			// 삭제처리 서비스
			int result = nboardService.deleteNboard(dto);
			if (result == 0) { // 삭제 실패
				message = "4";
			}
		}
		return message;
	}
	
	
	
	@PostMapping("nboardUpdate") 
	@ResponseBody
	public String updateNboard(NboardDto dto) throws Exception {

		String message = "1";
		
		// 암호확인 (고유번호&암호를 전송하여 확인)
		int cnt = nboardService.selectNboardPassCheck(dto);
		if( cnt == 0 ) {
			message = "2";  // 암호를 잘못 입력한 경우
		} else {
			// 저장서비스 실행
			int result = nboardService.updateNboard(dto);
			if( result == 0 ) message = "4";
		}
	
		return message;
	}

	@GetMapping("nboardList")
	public String selectNboardList(  DefaultDto defaultDto
									,ModelMap model) 
												throws Exception {
		
		// 총 데이터 개수
		int total = nboardService.selectNboardTotal(defaultDto);
		// 연산처리를 위해 dto에 값을 세팅(보냄)
		defaultDto.setTotal(total);

		// 총 페이지 개수를 계산 시키는 장면
		defaultDto.setTotalPage();
		// 계산 후 결과를 얻어옴
		int totalPage  = defaultDto.getTotalPage();

		// 출력 페이지의 시작 번호를 계산 시키는 장면
		defaultDto.setPageRownum();
		// 계산 후 결과를 얻어옴
		int pageRownum = defaultDto.getPageRownum();

		
		// SQL에 적용할 시작번호
		// 시작 번호의 계산 후 관련 변수에 값을 넣어 줌
		defaultDto.setFirstIndex();
		
		// SQL에 적용할 종료번호
		// 끝 번호의 계산 후 관련 변수에 값을 넣어 줌
		defaultDto.setLastIndex();

		List<?> list1 = nboardService.selectNboardEmsisList(defaultDto); // (강조)데이터
		List<?> list2 = nboardService.selectNboardList(defaultDto); // (본) 데이터
		
		model.addAttribute("emsisList", list1);
		model.addAttribute("resultList", list2);
		
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageRownum", pageRownum);

		return "board/nboardList";
	}
	
	@GetMapping("nboardDetail/{seqid}")
	public String selectNboardDetail(@PathVariable int seqid
									              ,ModelMap model ) 
												throws Exception {
		
		nboardService.updateNboardHits(seqid);
		
		NboardDto dto = nboardService.selectNboardDetail(seqid);
		model.addAttribute("dto", dto);
		
		return "board/nboardDetail";
	}

}






