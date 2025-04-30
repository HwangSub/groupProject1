package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.BoardDto;
import com.myhome.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	/**
	 *  오버라이딩(상속관계에서 부모클래스의 메소드를 재구성 한다는 의미)
	 */
	@Override
	public List<?> selectBoardList(BoardDto dto) throws Exception {
		// 프로그램 작성
		return mapper.selectBoardList(dto);
	}

	@Override
	public int insertBoard(BoardDto dto) throws Exception {
		
		return mapper.insertBoard(dto);
	}

	@Override
	public BoardDto selectBoardDetail(int seqid) throws Exception {
		// 
		return mapper.selectBoardDetail(seqid);
	}

	@Override
	public int updateBoard(BoardDto dto) throws Exception {
		// ~~
		return mapper.updateBoard(dto);
	}

	@Override
	public void updateBoardHits(int seqid) throws Exception {

		mapper.updateBoardHits(seqid);
	}

	@Override
	public int deleteBoard(int seqid) throws Exception {
		
		return mapper.deleteBoard(seqid);
	}

	
}




