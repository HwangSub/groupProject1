package com.myhome.service;

import java.util.List;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;

public interface DataService {

	int insertDataboard(DataDto dto) throws Exception;

	int selectDataboardTotal(DefaultDto defaultDto) throws Exception;

	List<?> selectDataboardList(DefaultDto defaultDto) throws Exception;

	void updateDataboardHits(int seqid) throws Exception;

	DataDto selectDataboardDetail(int seqid) throws Exception;
	
}
