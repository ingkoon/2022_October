package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.member.model.MemberDto;

public interface MemberService {
	void create(MemberDto member) throws Exception;
	MemberDto read(String userId) throws Exception;
	List<MemberDto> readList() throws Exception;
	void update(MemberDto member) throws Exception;
	void delete(String userId) throws Exception;
}
