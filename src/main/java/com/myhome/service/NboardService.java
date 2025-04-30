package com.myhome.service;

import java.util.List;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;

public interface NboardService {

	/**
	 * (게시판)저장 처리
	 */
	int insertNboard(NboardDto dto) throws Exception;
	
	/**
	 * (게시판)수정 처리
	 */
	int updateNboard(NboardDto dto) throws Exception;
	
	/**
	 * (게시판)목록
	 */
	List<?> selectNboardList(DefaultDto defaultDto) throws Exception;

	/**
	 * (강조)목록
	 * @param defaultDto
	 * @return
	 */
	List<?> selectNboardEmsisList(DefaultDto defaultDto) throws Exception;
	
	/**
	 *  (게시판) 총 데이터 개수
	 */
	int selectNboardTotal(DefaultDto defaultDto) throws Exception;

	/**
	 * 상세보기
	 * @param seqid
	 * @return NboardDto
	 */
	NboardDto selectNboardDetail(int seqid) throws Exception;

	/**
	 *  조회수 증가
	 */
	void updateNboardHits(int seqid) throws Exception;

	/**
	 * 암호 확인
	 */
	int selectNboardPassCheck(NboardDto dto) throws Exception;

	/**
	 * 삭제 처리
	 */
	int deleteNboard(NboardDto dto) throws Exception;


	
}



