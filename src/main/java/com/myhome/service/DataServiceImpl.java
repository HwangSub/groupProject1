package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;
import com.myhome.mapper.DataMapper;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	DataMapper mapper;
	
	@Override
	public int insertDataboard(DataDto dto) throws Exception {
		return mapper.insertDataboard(dto);
	}

	@Override
	public int selectDataboardTotal(DefaultDto defaultDto) throws Exception {
		return mapper.selectDataboardTotal(defaultDto);
	}

	@Override
	public List<?> selectDataboardList(DefaultDto defaultDto) throws Exception {
		return mapper.selectDataboardList(defaultDto);
	}

	@Override
	public void updateDataboardHits(int seqid) throws Exception {
		mapper.updateDataboardHits(seqid);
	}

	@Override
	public DataDto selectDataboardDetail(int seqid) throws Exception {
		return mapper.selectDataboardDetail(seqid);
	}

}
