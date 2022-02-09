package com.my.chat20.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.chat20.vo.Follow;
import com.my.chat20.vo.Member;

public class FollowDao extends SqlSessionDaoSupport{
	
	
	
	public Follow selectFollow(Follow f) {
		return this.getSqlSession().selectOne("follow.selectFollow",f);
	}
	
	public int insert (Follow f) {
		return this.getSqlSession().insert("follow.insert",f);
	}
	
	public List<Member> getFollowByMember(Member m) {
		return this.getSqlSession().selectList("follow.getFollowByMember",m);
	}
	
	public int delFollow(Follow f) {
		return this.getSqlSession().delete("follow.delete",f);
	}
}
