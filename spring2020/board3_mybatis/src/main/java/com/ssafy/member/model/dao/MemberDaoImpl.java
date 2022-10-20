package com.ssafy.member.model.dao;

import java.sql.SQLException;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class MemberDaoImpl implements MemberDao {

	private final String NAMESPACE = "com.ssafy.model.dao.MemberDao.";
	
	@Override
	public int idCheck(String userId) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "idCheck", userId);
		}
	}

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert(NAMESPACE+"joinMember", memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			MemberDto member =sqlSession.selectOne(NAMESPACE+"loginMember", map);
			return member;
		}
	}

}
