package com.my.chat20.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.chat20.dao.ChatDao;
import com.my.chat20.vo.Chat;
import com.my.chat20.vo.Member;

@Controller
@RequestMapping("api")
public class ChatController {

	
	
	@Resource(name="ChatDao")
	private ChatDao chatDao;
	
	
	@RequestMapping(value="addChat", method=RequestMethod.GET)
	public @ResponseBody String addChat(
				@RequestParam(value="title") String title,
				@RequestParam(value="content") String content,
				HttpSession session
			
			) {
		
		
		Member member = (Member) session.getAttribute("user");
		
		int member_idx = member.getMember_idx();
		
		Chat chat = new Chat();
		chat.setTitle(title);
		chat.setContent(content);
		chat.setMember_idx(member_idx);
		
		chatDao.insert(chat);
		
		return "ok";
	}
	
	
	@RequestMapping(value="/getAllChat", method=RequestMethod.GET)
	public @ResponseBody List<Chat> getAllChat() {
		
		
		
		
		List<Chat> list = chatDao.getAllChat();
		
		return list;
	}
	
	
	@RequestMapping(value="/getChatByMember", method=RequestMethod.GET)
	public @ResponseBody List<Chat> getChatByMember(
				HttpSession session
			
			) {
		
		
		Member member = (Member) session.getAttribute("user");
		
		int member_idx = member.getMember_idx();
		
		Chat chat = new Chat();
		chat.setMember_idx(member_idx);
		
		List<Chat> list = chatDao.getChatByMember(chat);
		
		return list;
	}
	
	
	@RequestMapping(value="/getChat", method=RequestMethod.GET)
	public @ResponseBody Chat getChat(
				@RequestParam(value="chat_idx") int chat_idx
			
			) {
		
		
		Chat chat = new Chat();
		chat.setChat_idx(chat_idx);
		
		
		return chatDao.getChat(chat);
	}
	
	
	@RequestMapping(value="/delChat", method=RequestMethod.GET)
	public @ResponseBody String delChat(
				@RequestParam(value="chat_idx") int chat_idx
			
			) {
		
		Chat chat = new Chat();
		chat.setChat_idx(chat_idx);
		
		chatDao.delete(chat);
		
		
		return "ok";
	}
}














