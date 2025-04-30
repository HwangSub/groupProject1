package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;

@Mapper
public interface DataMapper {

	int insertDataboard(DataDto dto);

	int selectDataboardTotal(DefaultDto defaultDto);

	List<?> selectDataboardList(DefaultDto defaultDto);

	void updateDataboardHits(int seqid);

	DataDto selectDataboardDetail(int seqid);

}
