package com.myhome.service;

import java.util.List;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;

public interface MyService {

	/**
	 * 입력 처리
	 * @param dto
	 * @return Integer
	 * @throws Exception
	 */
	int insertMyboard(MyboardDto dto) throws Exception;

	/**
	 * 댓글 게시판 목록
	 * @param dto
	 * @return List
	 */
	List<?> selectMyboardList(DefaultDto dto) throws Exception;

	/**
	 * 댓글 총 개수
	 * @param defaultDto
	 * @return
	 */
	int selectMyboardTotal(DefaultDto defaultDto) throws Exception;

	/**
	 * 조회수 증가
	 */
	void updateMyboardHits(int seqid) throws Exception;

	/**
	 * 상세보기
	 * @param seqid
	 * @return
	 */
	MyboardDto selectMyboardDetail(int seqid) throws Exception;

	/**
	 * 댓글저장
	 * @param reboardto
	 * @return
	 */
	int insertReboard(ReboardDto reboardto) throws Exception;

	/**
	 * 댓글목록
	 * @return
	 */
	List<?> selectReboardList(int seqid) throws Exception;

	/**
	 * 댓글수정
	 * @param reboardto
	 * @return
	 */
	int updateReboard(ReboardDto reboardto) throws Exception;

	/**
	 * 댓글삭제
	 * @param reboardto
	 * @return
	 */
	int deleteReboard(ReboardDto reboardto) throws Exception;

	/**
	 * 댓글의 암호확인
	 * @param reboardto
	 * @return
	 */
	int selectReboardPassCheck(ReboardDto reboardto) throws Exception;

	/**
	 * 본글의 암호 확인
	 * @param myboardDto ( 시퀀스 값,암호 값)
	 * @return
	 */
	int selectMyboardPassCnt(MyboardDto myboardDto) throws Exception;

	/**
	 * 본글의 댓글 개수
	 * @param seqid
	 * @return
	 */
	int selectReboardPseqidCnt(int seqid) throws Exception;

	/**
	 * 본글 삭제 시 댓글이 존재하는 경우 (특정 문자열 **작성자에 의한 삭제**로 업데이트 처리)
	 * @param seqid
	 * @return
	 */
	int updateMyboardContent(int seqid) throws Exception;
	
	/**
	 * 본글 삭제 시 댓글이 없는 경우 삭제 처리
	 * @param seqid
	 * @return
	 */
	int deleteMyboard(int seqid) throws Exception;
	
	/**
	 * 본글 수정 처리
	 * @param dto
	 * @return
	 */
	int updateMyboard(MyboardDto dto) throws Exception;
}








