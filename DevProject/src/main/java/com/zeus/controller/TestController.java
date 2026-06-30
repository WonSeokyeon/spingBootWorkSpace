package com.zeus.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.dto.Address;
import com.zeus.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	private static final Address Address = null;

	@GetMapping("/test/posthome")
	public void posthome() {

	}

	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
	public String gohome(Model model, @ModelAttribute BoardDTO bd) {
		log.info("/test/gohome1 userId=" + bd.toString());
		if (bd.getHobbyArray() != null) {
			log.info("/test/gohome1 userId=" + bd.getHobbyArray().size());
		}
		return "/test/gohome1";

	}
	
	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Address> gohomeget(Model model, @ModelAttribute BoardDTO bd) {
		ArrayList<Address> addresslist = bd.getAddress();
		
		log.info("/test/gohome1 userId=" + bd.toString());

		return addresslist;

	}
}
