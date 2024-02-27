package com.javaex.guestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.guestDao.GuestDao;

@Service
public class GuestService {
	
	@Autowired
	private GuestDao gd;
	
	public void list() {
		
	}
}
