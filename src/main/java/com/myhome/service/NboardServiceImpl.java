package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.mapper.NboardMapper;

/* 객체지향 4대 요소 : 상속,다형성(오버라이딩),캡슐화,추상화 */

@Service
public class NboardServiceImpl implements NboardService {

	@Autowired
	NboardMapper mapper;
	
	@Override
	public int insertNboard(NboardDto dto) throws Exception {
		return mapper.insertNboard(dto);
	}

	@Override
	public List<?> selectNboardList(DefaultDto defaultDto) throws Exception {
		return mapper.selectNboardList(defaultDto);
	}

	@Override
	public int selectNboardTotal(DefaultDto defaultDto) throws Exception {
		return mapper.selectNboardTotal(defaultDto);
	}

	@Override
	public NboardDto selectNboardDetail(int seqid) throws Exception {
		return mapper.selectNboardDetail(seqid);
	}

	@Override
	public List<?> selectNboardEmsisList(DefaultDto defaultDto) throws Exception {
		return mapper.selectNboardEmsisList(defaultDto);
	}

	@Override
	public void updateNboardHits(int seqid) throws Exception {
		mapper.updateNboardHits(seqid);
	}

	@Override
	public int updateNboard(NboardDto dto) throws Exception {
		return mapper.updateNboard(dto);
	}

	@Override
	public int selectNboardPassCheck(NboardDto dto) throws Exception {
		return mapper.selectNboardPassCheck(dto);
	}

	@Override
	public int deleteNboard(NboardDto dto) throws Exception {
		return mapper.deleteNboard(dto);
	}
}




