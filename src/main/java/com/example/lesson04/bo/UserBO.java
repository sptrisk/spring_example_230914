package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	// input:파라미터들     output:X
	public void addUser(String name, String yyyymmdd, 
			String email, String introduce) {
		
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// input: X     output: User(있거나 or null)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	
	
	// input : name    output : boolean(true:중복 false:중복x)
	public boolean isDuplicatedbyName(String name) {
		return userMapper.isDuplicatedbyName(name);
	}
	
	
	
	
}