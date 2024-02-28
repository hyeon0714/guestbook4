package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	@Autowired
	private GuestDao gd;
	
	public List<GuestVo> list() {
		
		List<GuestVo> gList = gd.List();
		
		return gList;
	}
	
	public void insert(GuestVo gv) {
		
		gd.insert(gv);
	}
	
	public void delete(GuestVo gv) {
		
		gd.delete(gv);
	}
}
