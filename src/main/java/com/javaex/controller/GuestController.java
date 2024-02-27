package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.guestService.GuestService;

@Controller
@RequestMapping(value = "guest")
public class GuestController {
	
	@Autowired
	private GuestService gs;
	
	@RequestMapping(value = "addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addlist() {
		
		gs.list();
		
		return "addList";
		
	}
}
