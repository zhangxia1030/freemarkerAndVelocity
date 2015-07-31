package com.sxt.test.freemarker;

public class User {
	private String uname;
	private Address addr;
	
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public User(String uname, Address addr) {
		super();
		this.uname = uname;
		this.addr = addr;
	}
	
	public User() {
	}
}
