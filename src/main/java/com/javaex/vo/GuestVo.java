package com.javaex.vo;

public class GuestVo {

	private int no;
	private String name;
	private String password;
	private String content;
	private String date;
	
	public GuestVo() {
		super();
	}

	
	
	
	
	
	
	
	public GuestVo(int no, String password) {
		super();
		this.no = no;
		this.password = password;
	}








	public GuestVo(String name, String password, String content) {
		super();
		this.name = name;
		this.password = password;
		this.content = content;
	}





	public GuestVo(int no, String name, String password, String content, String date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	
	
	
}
