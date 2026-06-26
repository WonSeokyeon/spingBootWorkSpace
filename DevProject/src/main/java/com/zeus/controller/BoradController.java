package com.zeus.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.dto.BoardDTO;
import com.zeus.dto.Meber;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value="/board")
public class BoradController {
	
	@RequestMapping(value = "/ajaxhome", method = RequestMethod.GET)
	public String ajaxhome() {
		return "board/ajaxhome";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "board/home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert() {
		return "board/insert";
	}

	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select2(Model model) {
		model.addAttribute("boardNo", "해당된 번호는 없음");
		return "board/select";
	}
	
	@GetMapping(value = "/select", params = "register")
	public String select3(Model model) {
		model.addAttribute("boardNo", "register값은 없어");
		return "board/select";
	}
	
	@RequestMapping(value = "/select/{boardNo}", method = RequestMethod.GET)
	public String select1(@PathVariable("boardNo") int boardNo, Model model) {
		model.addAttribute("boardNo", boardNo);
		return "board/select";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		return "board/delete";
	}

	@RequestMapping(value = "/updata", method = RequestMethod.GET)
	public String updata1(Model model) {
		return "board/updata";
	}
	
	@PutMapping(value = "/updata/{boardNo}")
	public ResponseEntity<String> updata2(@PathVariable("boardNo") int boardNo, @RequestBody BoardDTO boardDTO) {
		log.info("BoardDTO "+boardDTO);
		ResponseEntity<String> message =  new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return message;
	}
	
	@PutMapping(value = "/updata/{boardNo}",headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> updata3(@PathVariable("boardNo") int boardNo, @RequestBody BoardDTO boardDTO) {
		log.info("headers BoardDTO "+boardDTO);
		ResponseEntity<String> message =  new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return message;
	}


}
