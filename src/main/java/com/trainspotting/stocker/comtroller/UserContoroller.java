package com.trainspotting.stocker.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserContoroller {
	
	@GetMapping("/signup")
	public void signup() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
