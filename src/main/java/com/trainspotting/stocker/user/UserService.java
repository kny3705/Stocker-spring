package com.trainspotting.stocker.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainspotting.stocker.model.User;
import com.trainspotting.stocker.util.SecurityUtil;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SecurityUtil security;
	
	public int signup(User param) {		
		if(mapper.select(param) != null) return -1;
		
		String plain = param.getPw();
		String hash = security.getHashed(plain);
		
		param.setPw(hash);
		
		return mapper.insert(param);
	}
	
	public int login(User param, HttpSession session) {
		User data = mapper.select(param);
		
		if(data == null) return -1;
		
		String plain = param.getPw();
		String hashed = data.getPw();
		if(!security.checkPw(plain, hashed)) return -2;
		
		data.setPw(null);
		session.setAttribute("current_user", data);
		return 1;
	}
	
}
