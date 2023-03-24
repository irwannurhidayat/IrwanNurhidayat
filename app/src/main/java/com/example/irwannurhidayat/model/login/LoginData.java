package com.example.irwannurhidayat.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("user_id")
	private int userId;

	@SerializedName("name")
	private String name;

	@SerializedName("username")
	private String username;

	public void setUserId(int userId){
		this.userId = userId;
	}

	public String getUserId(){
		return String.valueOf((userId));
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}