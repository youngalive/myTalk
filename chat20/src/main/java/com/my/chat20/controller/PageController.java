package com.my.chat20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	
	
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/addUser" , method=RequestMethod.GET)
	public String addUser() {
		return "add-user";
	}
	
	@RequestMapping(value="/addChat" , method=RequestMethod.GET)
	public String addChat() {
		return "add-chat";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/my" , method=RequestMethod.GET)
	public String my() {
		return "my";
	}
	
	
	@RequestMapping(value="/chatroom" , method=RequestMethod.GET)
	public String chatroom() {
		return "chat-room";
	}
	
	
}
