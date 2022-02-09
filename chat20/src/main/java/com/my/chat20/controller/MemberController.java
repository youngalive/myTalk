package com.my.chat20.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.chat20.dao.MemberDao;
import com.my.chat20.vo.Member;

@Controller
@RequestMapping("api")
public class MemberController {

	
	
	@Resource(name="MemberDao")
	private MemberDao memberDao;
	
	
	@RequestMapping(value="getAllMember" , method=RequestMethod.GET)
	public @ResponseBody List<Member> getAllMember(){
		
		
		List<Member> list = memberDao.getAllMember();
		
		
		return list;
		
	}
	
	
	@RequestMapping(value="/addUser" , method=RequestMethod.GET)
	public @ResponseBody String addUser(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				@RequestParam(value="nick") String nick,
				@RequestParam(value="intro") String intro
			) {
		
		
		
		Member newMem = new Member();
		newMem.setId(id);
		newMem.setPw(pw);
		newMem.setNick(nick);
		newMem.setIntro(intro);
		
		memberDao.insert(newMem);
		
		return "ok";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public @ResponseBody String login(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				HttpSession session
			) {
		
		
		
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		
		
		Member result = memberDao.selectByIdAndPw(m);
		if(result!=null) {
			session.setAttribute("user", result);
			return "ok";
		}else {
			return "fail";
		}
		
		
		
	}
	
	
	@RequestMapping(value="/logout" , method=RequestMethod.GET)
	public @ResponseBody String logout(
				HttpSession session
			) {
		
		session.invalidate();
		return "ok";
		
	}
	
	
	
	
}
