package com.iss.po;

public class Users {
	private String user_id;
	private String user_name;
	private String password;
	private int integral;
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", integral="
				+ integral + ", phonenum=" + phonenum + "]";
	}
	private String phonenum;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
}
