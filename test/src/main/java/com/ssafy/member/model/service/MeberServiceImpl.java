package com.ssafy.member.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MeberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;
		
	public MeberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public void create(MemberDto member) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.create(member);

	}

	@Override
	public MemberDto read(String userId) throws Exception {
		// TODO Auto-generated method stub
		MemberDto member = memberMapper.read(userId);
		return member;
	}

	@Override
	public List<MemberDto> readList() throws Exception {
		// TODO Auto-generated method stub
		List<MemberDto> list = memberMapper.readList();
		return list;
	}

	@Override
	public void update(MemberDto member) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.update(member);
	}

	@Override
	public void delete(String userId) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.delete(userId);
	}

}
