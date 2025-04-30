package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	List<?> selectBoardList(BoardDto dto);

	int insertBoard(BoardDto dto);

	BoardDto selectBoardDetail(int seqid);

	int updateBoard(BoardDto dto);

	void updateBoardHits(int seqid);

	int deleteBoard(int seqid);	
}
