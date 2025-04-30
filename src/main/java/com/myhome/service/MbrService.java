package com.myhome.service;

import java.util.List;

import com.myhome.dto.MbrDto;

public interface MbrService {

	// 저장처리
	int insertMbr(MbrDto dto) throws Exception;

	// 수정처리
	int updateMbr(MbrDto dto) throws Exception;
	
	// 삭제처리
	int deleteMbr(String userid) throws Exception;
	
	// 회원목록 - 검색
	List<?> selectMbrList(MbrDto dto) throws Exception; 
	
	// Total 건수
	int selectMbrTotal(MbrDto dto) throws Exception; 
	
	// 상세보기
	MbrDto selectMbrDetail(String userid) throws Exception;
	

	
}






