package com.ssafy.board.model.mapper;

import java.util.Map;

import com.ssafy.board.model.MemberDto;

public interface MemberMapper {
	int idCheck(String id) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
}
