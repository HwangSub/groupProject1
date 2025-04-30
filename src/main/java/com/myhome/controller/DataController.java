package com.myhome.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;
import com.myhome.service.DataService;


@Controller
public class DataController {

	@Autowired
	DataService dataService;
	
	// 클래스(전역)변수
	public static String path= "C:/Users/hi_guri/git/spring102/myhome101/src/main/webapp/data";

	@GetMapping("dataWrite")
	public String dataWrite() {
		
		return "board/dataWrite";
	}
	
	@PostMapping("dataBoardInsert")
	@ResponseBody
	public String insertDataBoard(   MultipartHttpServletRequest request
									,DataDto dto ) 
											throws Exception {
		String message = "ok";

		// 넘어온 데이터를 가져옴
		Map map = request.getFileMap();
		
		// Map의 키값(들)을 가져옴
		Iterator it = map.entrySet().iterator();
		
		String filenames = "";
		
		int cnt = 0;
		
		while( it.hasNext() ) { // 파일의 존재 유무
			
			// 키값이 있는 위치로 커서를 내려보냄
			Entry entry = (Entry) it.next();
		
			// 해당 위치에서 파일의 정보들을 가져온다. 
			MultipartFile file = (MultipartFile)entry.getValue();
			if( file.getSize() > 0 ) {

				String filename = System.currentTimeMillis()+"-"+cnt;
				// abc.jpg -> f2[0] = "abc"; f2[1] = "jpg";
				String f1 = file.getOriginalFilename();
				String[] f2 = f1.split("\\.");
				String exe  = f2[f2.length-1];
				filename += "."+exe;
				
				String filepath = path+"/"+filename;

				// {실 저장} / {파일 카피}
				file.transferTo(new File(filepath));
				filenames += filename+"／";
			}
			cnt++;
		}
		
		dto.setFilepath("/webapp/data");
		dto.setFilename(filenames);
		
		int result = dataService.insertDataboard(dto);
		if( result == 0 ) message = "fail";
		
		return message;
	}
	
	
	@GetMapping("dataList")
	public String selectDataboardList(DefaultDto defaultDto, ModelMap model) throws Exception {

		int total = dataService.selectDataboardTotal(defaultDto);
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
		List<?> list = dataService.selectDataboardList(defaultDto);
		List<Map> list2 = new ArrayList<Map>();
		
		for( int i=0; i<list.size(); i++) {
			Map map = (Map)list.get(i);
			String files = (String)map.get("FILENAME");
			if( files != null) {
				files = filesNewMake(files);
				map.put("FILENAME", files);
			}
			list2.add(map);
		}
		model.addAttribute("resultList", list2);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageRownum", pageRownum);
		
		return "board/dataList";
	}
	
	@GetMapping("dataDetail/{seqid}")
	public String selectDataboardDetail( @PathVariable int seqid
										,ModelMap model) 
												throws Exception {
		dataService.updateDataboardHits(seqid);
		
		DataDto dto = dataService.selectDataboardDetail(seqid);

		String files = dto.getFilename().trim();
		files = filesNewMake(files);
		
		dto.setFilename(files);
		model.addAttribute("dto", dto);

		return "board/dataDetail";
	}
	
	public static String filesNewMake(String files) {
		
		if( !files.equals("") ) {
			String[] str = files.split("／");
			for(int i=0; i<str.length; i++) {
				String fname = str[i]; // 예) 1745981505439-1.txt
				String filepath = path+"/"+fname;
				File file = new File(filepath);
				if(file.exists() == false) {
					files = files.replace(fname+"／", "");
				}
			}
		}
		return files;
	}
	
	
	
	
}
