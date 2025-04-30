package com.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myhome.dto.MbrDto;
import com.myhome.service.MbrService;

@Controller
public class MbrController {

	@Autowired
	MbrService mbrService;
	
	@GetMapping("mbrWrite")
	public String mbrWrite() {
		return "member/mbrWrite";
	}
	
	@PostMapping("mbrInsert")
	public String insertMbr(MbrDto dto) throws Exception {
		// 서비스 실행
		int cnt = mbrService.insertMbr(dto);
		if( cnt == 1 ) {
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패!!");
		}
		return "redirect:/mbrList";
	}
	
	@PostMapping("mbrUpdate")
	public String updateMbr(MbrDto dto) throws Exception {
		// 서비스 실행
		int cnt = mbrService.updateMbr(dto);
		if( cnt == 1 ) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패!!");
		}
		return "redirect:/mbrList";
	}
	
	@GetMapping("mbrList")
	public String selectMbrList(MbrDto dto, ModelMap model) throws Exception {

		int total = mbrService.selectMbrTotal(dto);
		int pageRownum = total;
		
		List<?> list = mbrService.selectMbrList(dto);
		model.addAttribute("resultList", list);
		model.addAttribute("total", total);
		model.addAttribute("pageRownum", pageRownum);

		return "member/mbrList";
	}
	
	@GetMapping("mbrDetail/{userid}")
	public String selectMbrDetail
							(@PathVariable String userid, ModelMap model) 
												throws Exception {
		MbrDto dto = mbrService.selectMbrDetail(userid);
		model.addAttribute("dto", dto);		
		return "member/mbrDetail";
	}
	
	@GetMapping("mbrDelete/{userid}")
	public String deleteMbr(@PathVariable String userid) 
											throws Exception {
		int result = mbrService.deleteMbr(userid);
		return "redirect:/mbrList";
	}
	
	@GetMapping("mbrModify/{userid}")
	public String selectMbrModify(@PathVariable String userid, ModelMap model) 
												throws Exception {
		
		MbrDto dto = mbrService.selectMbrDetail(userid);
		model.addAttribute("dto", dto);
		
		return "member/mbrModify";
	}
	


	
}







