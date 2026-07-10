package com.zeus.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.dto.CodeLabelValue;
import com.zeus.dto.Meber;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Springcontroller {
	@RequestMapping(value = "/spring/form1", method = RequestMethod.GET)
	public String springForm1(Model model) {
		log.info("/spring/form1");
		Meber member = new Meber();
		member.setUserId("hong");
		member.setUserName("홍길동");
		member.setPassword("1234567");
		member.setEmail("zeus@nate.com");
		member.setIntroduction("하이루. 나는 누굴까요");

		// 체크박스
//		List<CodeLabelValue> hobbylist = new ArrayList<>();
		// hobbylist.add(new CodeLabelValue("01", "축구"));
		// hobbylist.add(new CodeLabelValue("02", "등산"));
		// hobbylist.add(new CodeLabelValue("03", "야구"));

		Map<String, String> hobbyMap = new LinkedHashMap<>();
		hobbyMap.put("축구", "01");
		hobbyMap.put("야구", "02");
		hobbyMap.put("배구", "03");

		member.setHobbyMap(hobbyMap);
		// 외국 여부
		member.setForeigner(true);

		// hobbyArray(UI 각 항목이 존재함)
		List<String> hobbyList2 = new ArrayList<>();
		hobbyList2.add("sport");
		hobbyList2.add("movie");
		hobbyList2.add("music");
		member.setHobbyList2(hobbyList2);

		model.addAttribute("member", member);
		return "spring/form1";
	}

	@RequestMapping(value = "/spring/form2", method = RequestMethod.POST)
	// @ResponseBody
	public void register(Model model, @Validated Meber member, BindingResult result, RedirectAttributes rttr) {
		log.info("/spring/register");

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalErrors.size() = " + globalErrors.size());
			log.info("fieldErrors.size() = " + fieldErrors.size());
			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError = " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("globalError = " + objectError);
			}

			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);

				log.info("fieldError = " + fieldError);
				log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			rttr.addFlashAttribute("message", "입력값에 에러가 발생했습니다.");
			
		}
	}
}
