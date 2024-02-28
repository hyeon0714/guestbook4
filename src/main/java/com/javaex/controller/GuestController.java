package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value = "guest")
public class GuestController {
	
	@Autowired
	private GuestService gs;
	
	@RequestMapping(value = "addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		List<GuestVo> gList = gs.list();
		
		model.addAttribute("gList", gList);
		
		return "addList";
	}
	
	@RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute GuestVo gv) {
		
		gs.insert(gv);
		return "redirect:/guest/addlist";
	}
	
	@RequestMapping(value = "deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		return "deleteForm";
	}
	
	@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo gv) {
		
		gs.delete(gv);
			
		return "redirect:/guest/addlist";
	}
	
}
