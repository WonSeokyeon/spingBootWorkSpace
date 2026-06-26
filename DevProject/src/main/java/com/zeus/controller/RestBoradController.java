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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.dto.BoardDTO;
import com.zeus.dto.Meber;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Log
@RestController
@RequestMapping(value = "/board")
public class RestBoradController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		return "안녕하세요";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BoardDTO list() {
		BoardDTO bto = new  BoardDTO();
		bto.setBoardNo(10);
		bto.setContent("est");
		bto.setTitle("하이루");
		bto.setTitle("sfdsf");
		return bto;
	}
	
	@RequestMapping(value = "/listarray", method = RequestMethod.GET)
	public @ResponseBody List<BoardDTO> listarray() {
	    
	    // 제네릭(<>)을 추가하여 타입 안전성 확보
	    List<BoardDTO> list = new ArrayList<>(); 
	    
	    for (int i = 0; i < 10; i++) {
	        BoardDTO bto = new BoardDTO();
	        bto.setBoardNo(i);
	        bto.setContent("test" + i);  // "est" 오타 수정
	        bto.setTitle("하이루" + i);    // 덮어쓰기 코드 제거
	        
	        // ✨ [해결] 생성한 객체를 리스트에 반드시 추가해야 합니다!
	        list.add(bto); 
	    }
	    return list; // 이제 10개의 데이터가 들어있는 리스트가 정상 반환됩니다.
	}
}
