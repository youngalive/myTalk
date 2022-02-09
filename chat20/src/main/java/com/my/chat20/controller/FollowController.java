package com.my.chat20.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.chat20.dao.FollowDao;
import com.my.chat20.vo.Follow;
import com.my.chat20.vo.Member;

@Controller
@RequestMapping("api")
public class FollowController {

	
	
	@Resource(name="FollowDao")
	private FollowDao followDao;
	
	
	@RequestMapping(value="/addFollow",method=RequestMethod.GET)
	public @ResponseBody String addFollow(
				@RequestParam(value="star_idx") int star_idx,
				HttpSession session
			) {
		
		int member_idx = ((Member) session.getAttribute("user")).getMember_idx();
		Follow follow = new Follow();
		follow.setFan_idx(member_idx);
		follow.setStar_idx(star_idx);
		
		
		Follow resultFollow = followDao.selectFollow(follow);
		if(resultFollow==null) {
			followDao.insert(follow);
			return "ok";
		}else {
			return "ex";
		}
		
	}
	
	@RequestMapping(value="/delFollow",method=RequestMethod.GET)
	public @ResponseBody String delFollow(
				@RequestParam(value="star_idx") int star_idx,
				HttpSession session
			) {
		
		int member_idx = ((Member) session.getAttribute("user")).getMember_idx();
		Follow follow = new Follow();
		follow.setFan_idx(member_idx);
		follow.setStar_idx(star_idx);
		
		
		followDao.delFollow(follow);
		
		return "ok";
		
	}
	
	@RequestMapping(value="/getFollowByMember",method=RequestMethod.GET)
	public @ResponseBody List<Member> getFollowByMember(
				HttpSession session
			) {
		
		int member_idx = ((Member) session.getAttribute("user")).getMember_idx();
		Member member =  new Member();
		member.setMember_idx(member_idx);
		
		
		List<Member> list = followDao.getFollowByMember(member);
		
		
		return list;
	}
	
}
