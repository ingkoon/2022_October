package com.ssafy.board.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.MemberDto;
import com.ssafy.board.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	@Transactional(readOnly = true)
	public int idCheck(String id) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.idCheck(id);		
	}

	@Override
	@Transactional
	public void registerMember(MemberDto memberDto) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.registerMember(memberDto);
	}

	@Override
	@Transactional(readOnly = true)
	public MemberDto login(MemberDto memberDto) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		return memberMapper.login(memberDto);
	}
}
