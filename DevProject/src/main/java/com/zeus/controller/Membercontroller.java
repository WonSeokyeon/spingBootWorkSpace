package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Membercontroller {
	@RequestMapping(value = "/member/model01", method = RequestMethod.GET)
	public String model01(Model model) {
		
		model.addAttribute("userId","123456");
		
		return "member/model01";
		
		
	}
	


}
