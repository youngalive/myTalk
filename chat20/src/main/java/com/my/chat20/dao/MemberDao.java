package com.my.chat20.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.chat20.vo.Member;

public class MemberDao extends SqlSessionDaoSupport{
	
	
	
	public int insert(Member member) {
		return this.getSqlSession().insert("member.insert",member);
	}
	
	
	public Member selectByIdAndPw(Member member) {
		return this.getSqlSession().selectOne("member.selectByIdAndPw",member);
	}
	
	
	public List<Member> getAllMember() {
		return this.getSqlSession().selectList("member.getAllMember");
	}
	
	
	
	
}
