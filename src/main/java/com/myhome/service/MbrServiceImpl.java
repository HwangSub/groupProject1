package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myhome.dto.MbrDto;
import com.myhome.mapper.MbrMapper;

@Service
public class MbrServiceImpl implements MbrService {

	@Autowired
	MbrMapper mapper;
	
	@Override
	public int insertMbr(MbrDto dto) throws Exception {
		return mapper.insertMbr(dto);
	}

	@Override
	public List<?> selectMbrList(MbrDto dto) throws Exception {
		
		return mapper.selectMbrList(dto);
	}

	@Override
	public int selectMbrTotal(MbrDto dto) throws Exception {
		
		return mapper.selectMbrTotal(dto);
	}

	@Override
	public MbrDto selectMbrDetail(String userid) throws Exception {
		
		return mapper.selectMbrDetail(userid);
	}

	@Override
	public int deleteMbr(String userid) throws Exception {
		return mapper.deleteMbr(userid);
	}

	@Override
	public int updateMbr(MbrDto dto) throws Exception {
		return mapper.updateMbr(dto);
	}

}
