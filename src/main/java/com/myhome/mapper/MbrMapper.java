package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.MbrDto;

@Mapper
public interface MbrMapper {

	int insertMbr(MbrDto dto);
	List<?> selectMbrList(MbrDto dto);
	int selectMbrTotal(MbrDto dto);
	MbrDto selectMbrDetail(String userid);
	int deleteMbr(String userid);
	int updateMbr(MbrDto dto);

}
