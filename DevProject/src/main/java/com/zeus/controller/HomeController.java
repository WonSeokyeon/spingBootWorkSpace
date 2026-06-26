package com.zeus.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.dto.Meber;

import lombok.extern.slf4j.Slf4j;

//뷰화면에서 사용자 요청을 받는 클래스
@Slf4j
@Controller
public class HomeController {
	// http://192.168.0.45:8080/home 요청을 하면 여기서 받는다.
	// method : get, post
	// 1.get 방식 2./home 요청한다. 3.해당된 함수에서 처리하고 4.화면을 보여줘야된다(return "home")
	@RequestMapping(value = "/home")
	public String home() {
		// 비즈니스 로직 처리(데이터베이스 부르고 => 연산하고 => 결과값 home.jsp 보내준다.)
		Date date = new Date();
		log.info(String.format("접속시간: %s", date.toString()));
		return "home";
	}

	@RequestMapping(value = "/set")
	public String mainpage() {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		return "set";
	}

	@GetMapping(value = "/home1")
	public String home1(Model model) {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		log.info("사용자가 home1 선택함.");
		model.addAttribute("serverTime", (new Date().toString()));
		return "home1";
	}

	@GetMapping(value = "/home2")
	public String home2(Model model) {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		log.info("사용자가 home2 선택함.");
		Meber member = new Meber();
		member.setEmail("tjrdus@naver.com");
		member.setPassword("123455");
		member.setUserId("userId");
		member.setUserName("zeus");
		LocalDate Id = LocalDate.of(2026, 6, 25);
		member.setDateOfBirth(Id);
		model.addAttribute("member", member); // 이름이 달라서 불러와야된다.
		model.addAttribute("serverTime", (new Date().toString()));
		return "home2";
	}

	@GetMapping(value = "/home3")
	public String home3(Model model) {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		model.addAttribute("serverTime", (new Date().toString()));
		return "home3";
	}

	@GetMapping(value = "/home4")
	public String home4(Model model) {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		log.info("사용자가 home4 선택함.");
		String[] hobbyArryay = new String[] { "놀기", "밥먹기", "자기" };
		model.addAttribute("hobbyArryay", hobbyArryay);
		List<String> list = new ArrayList<String>();
		list.add("자바");
		list.add("자바스크립트");
		list.add("스프링 부터");
		list.add("파이썬");
		model.addAttribute("list", list);
		
		Map<String,String> map= new HashMap<String,String>();
		map.put("data1", "자바");
		map.put("data2", "자바스크립트");
		map.put("data3", "스프링 부트");
		map.put("data4", "파이썬");
		model.addAttribute("map", map);
		
		
		String hobbyString = "java,python,spring";
				
		model.addAttribute("hobbyString",hobbyString);
		model.addAttribute("serverTime", (new Date().toString()));
		return "home4";
	}

	@GetMapping(value = "/home5")
	public void home5(Model model) {

		log.info("사용자가 home4 선택함.");	
		model.addAttribute("serverTime", (new Date().toString()));
	
	}
	
	@GetMapping(value = "/home6")
	public String home6(Model model) {
		// 비즈니스 로직(DB부르고=> 연산하고=>결과값 home.jsp
		log.info("사용자가 home6 선택함.");
		model.addAttribute("serverTime", (new Date().toString()));
		return "home6";
	}
}
