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
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;
import com.myhome.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService myService;
	
	@GetMapping("myboardWrite")
	public String myboardWrite() {
		return "board/myboardWrite";
	}
	
	@PostMapping("myboardInsert")
	@ResponseBody
	public String insertMyboard(MyboardDto dto) throws Exception {

		String message = "ok";
		// 저장(등록) 서비스 실행
		int result = myService.insertMyboard(dto);
		if (result == 0) message = "fail";
		return message;
	}
	

	/**
	 * 수정처리
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("myboardUpdate")
	@ResponseBody
	public String updateMyboard(MyboardDto dto) throws Exception {

		String message = "1"; // 저장성공
		// 암호 일치 검사
		// 일치하면 1 , 일치하지 않으면 0
		int passCheckCnt = myService.selectMyboardPassCnt(dto); 
		if( passCheckCnt == 0 ) {
			message = "2";
		} else {
			// 저장(수정) 서비스 실행
			int result = myService.updateMyboard(dto);
			if (result == 0) message = "4"; // 저장실패
		}
		return message;
	}

	@PostMapping("reboardInsert")
	@ResponseBody
	public String insertReboard(ReboardDto reboardto) throws Exception {

		String message = "1";
		int result = myService.insertReboard(reboardto);
		if( result == 0 ) message = "4";
		
		return message;
	}
	
	@PostMapping("reboardUpdate")
	@ResponseBody
	public String updateReboard(ReboardDto reboardto) throws Exception {
		
		String message = "1";
		//System.out.println( "comment :: " + reboardto.getCmmt() );
		// 암호 검사 => 데이터의 (시퀀스 값) + (암호) 전송
		int passCheckCnt =  myService.selectReboardPassCheck(reboardto);
		if( passCheckCnt == 0 ) {
			message = "2";
		} else {
			int result = myService.updateReboard(reboardto);
			if( result == 0 ) message = "4";
		}
		return message;
	}
	
	@PostMapping("reboardDelete")
	@ResponseBody
	public String deleteReboard(ReboardDto reboardto) throws Exception {
		
		String message = "1";
		// 암호 검사 => 데이터의 (시퀀스 값) + (암호) 전송
		int passCheckCnt =  myService.selectReboardPassCheck(reboardto);
		if( passCheckCnt == 0 ) {
			message = "2";
		} else {
			int result = myService.deleteReboard(reboardto);
			if( result == 0 ) message = "4";
		}
		return message;
	}
	
	
	@PostMapping("myboardDelete")
	@ResponseBody
	public String deleteMyboard(MyboardDto myboardDto) throws Exception {
	
		String message = "1"; // 삭제 성공 번호
		int result = 0;
		
		// 암호 검사 (본글)
		int passCheckCnt = myService.selectMyboardPassCnt(myboardDto);
		
		if( passCheckCnt == 0 ) { // 암호 잘못 입력
			message = "2";
		} else {
			// 하위 댓글 개수 얻기
			int reCnt = myService.selectReboardPseqidCnt(myboardDto.getSeqid());
			
			if( reCnt > 0 ) { 	// 댓글이 1개 이상
				// 업데이트를 세팅
				result = myService.updateMyboardContent(myboardDto.getSeqid());
				// "글쓴이에 의한 삭제" 라는 글로 업데이트
				message = "3";
			} else { 			// 댓글이 없는 경우
				// 삭제를 세팅
				result = myService.deleteMyboard(myboardDto.getSeqid());
			}
			// 삭제 실패 시 세팅
			if(result == 0) message = "4"; 
		}
		return message;
	}
	

	@GetMapping("myboardList")
	public String selectMyboardList(DefaultDto defaultDto, ModelMap model) throws Exception {

		int total = myService.selectMyboardTotal(defaultDto);
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

		// 서비스 실행
		List<?> list = myService.selectMyboardList(defaultDto);

		model.addAttribute("resultList", list);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageRownum", pageRownum);
		
		return "board/myboardList";
	}
	
	@GetMapping("myboardDetail/{seqid}")
	public String selectMyboardDetail(@PathVariable int seqid
			                                       ,ModelMap model) 
												throws Exception {
		// 조회수 증가 서비스 실행
		myService.updateMyboardHits(seqid);

		// 상세보기 서비스 실행
		MyboardDto dto = myService.selectMyboardDetail(seqid);
		
		// 댓글 목록 서비스 실행
		List<?> list = myService.selectReboardList(seqid);

		model.addAttribute("dto", dto);
		model.addAttribute("list", list);

		return "board/myboardDetail";
	}
	
	@GetMapping("myboardModify/{seqid}")
	public String selectMyboardModfiy(@PathVariable int seqid
			                                       ,ModelMap model) 
												throws Exception {
		// 상세보기 서비스 실행
		MyboardDto dto = myService.selectMyboardDetail(seqid);
		model.addAttribute("dto", dto);
		
		return "board/myboardModify";
	}

	@GetMapping("passWrite2/{seqid}")
	public String passWrite2(@PathVariable int seqid
			                              ,ModelMap model) 
												throws Exception {
		model.addAttribute("seqid", seqid);
		return "board/passWrite2";
	}
	

}






