package com.my.chat20.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.chat20.vo.Chat;

public class ChatDao extends SqlSessionDaoSupport{
	
	
	
	public int insert(Chat c) {
		return this.getSqlSession().insert("chat.insert",c);
	}
	
	
	public List<Chat> getChatByMember(Chat c) {
		return this.getSqlSession().selectList("chat.getChatByMember",c);
	}
	
	public List<Chat> getAllChat() {
		return this.getSqlSession().selectList("chat.getAllChat");
	}
	
	
	public Chat getChat(Chat c) {
		return this.getSqlSession().selectOne("chat.getChat",c);
	}
	
	
	public int delete(Chat c) {
		return this.getSqlSession().delete("chat.delete",c);
	}
	
	
	

}
