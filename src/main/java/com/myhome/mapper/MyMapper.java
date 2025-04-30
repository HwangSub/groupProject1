package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;

@Mapper
public interface MyMapper {

	int insertMyboard(MyboardDto dto);

	List<?> selectMyboardList(DefaultDto dto);

	int selectMyboardTotal(DefaultDto defaultDto);

	void updateMyboardHits(int seqid);

	MyboardDto selectMyboardDetail(int seqid);

	int insertReboard(ReboardDto reboardto);

	List<?> selectReboardList(int seqid);

	int updateReboard(ReboardDto reboardto);

	int deleteReboard(ReboardDto reboardto);

	int selectReboardPassCheck(ReboardDto reboardto);

	int selectReboardPseqidCnt(int seqid);

	int selectMyboardPassCnt(MyboardDto myboardDto);

	int updateMyboardContent(int seqid);

	int deleteMyboard(int seqid);

	int updateMyboard(MyboardDto dto);
}



