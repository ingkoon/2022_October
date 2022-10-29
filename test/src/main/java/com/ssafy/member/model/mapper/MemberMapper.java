package com.ssafy.member.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {
	
	void create(MemberDto member) throws SQLException;
	MemberDto read(String userId) throws SQLException;
	List<MemberDto> readList() throws SQLException;
	void update(MemberDto member) throws SQLException;
	void delete(String userId) throws SQLException;

}
