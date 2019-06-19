package com.kitri.member.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.sqlmap.MybatisConfiguration;

public class MemberDaoImpl implements MemberDao {

	private final String NAME_SPACE = "com.kitri.member.model.dao.MemberDao";
	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}


	private MemberDaoImpl() {
		
	}


	@Override
	public int idcheck(String id) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".idCheck", id);
		} finally {
			session.close();
		}
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectList(NAME_SPACE + ".zipSearch", doro);
		} finally {
			session.close();
		}
	}

	@Override
	public int registerMember(MemberDetailDto memberDetialDto) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.insert(NAME_SPACE + ".registerMember", memberDetialDto);
			session.commit();
			return 1;
		} finally {
			session.close();
		}
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".loginMember", map);
		} finally {
			session.close();
		}
	}

	@Override
	public MemberDetailDto getMember(String id) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".getMember", id);
		} finally {
			session.close();
		}
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetialDto) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.update(NAME_SPACE + ".modifyMember1", memberDetialDto);
			session.update(NAME_SPACE + ".modifyMember2", memberDetialDto);
			session.commit();
			return 2;
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteMember(String id) {
		SqlSession session = MybatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.delete(NAME_SPACE + ".deleteMember1", id);
			session.delete(NAME_SPACE + ".deleteMember2", id);
			session.commit();
			return 2;
		} finally {
			session.close();
		}
	}
}
