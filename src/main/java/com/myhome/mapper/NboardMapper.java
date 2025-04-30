package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;

@Mapper
public interface NboardMapper {

	int insertNboard(NboardDto dto);
	
	List<?> selectNboardList(DefaultDto defaultDto);
	
	int selectNboardTotal(DefaultDto defaultDto);
	
	NboardDto selectNboardDetail(int seqid);
	
	List<?> selectNboardEmsisList(DefaultDto defaultDto);

	void updateNboardHits(int seqid);

	int updateNboard(NboardDto dto);

	int selectNboardPassCheck(NboardDto dto);

	int deleteNboard(NboardDto dto);

}




