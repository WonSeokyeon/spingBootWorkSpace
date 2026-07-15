package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.dto.BoardDTO;
import com.zeus.service.BoardService;
import com.zeus.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService Service;

	// 1. 회원 입력창화면 요청 (읽기 전용)
	@GetMapping(value = "/insertForm")
	@Transactional(readOnly = true)
	public String memberInsertForm(Member member, Model model) {
		model.addAttribute("Member", member);
		return "user/insertForm";
	}

	// 2. 게시판 입력 내용 저장 요청
	@PostMapping(value = "/insert")
	public String userInsert(Member member, Model model) throws Exception {
		log.info("user/insert" + member.toString());
		boolean result = Service.insert(member);

		if (result == true) {
			return "user/success";
		}
		return "user/fail";
	}

	// 3. 사용자 입력창화면 요청 (읽기 전용)
	@GetMapping(value = "/list")

	public String userlist(Member member, Model model) throws Exception {
		List<Member> memberlist = Service.list();
		model.addAttribute("list", memberlist);

		return "user/list";
	}

	// 4. 사용자 수정화면 요청
	@GetMapping(value = "/updateForm")
	public String userupdate(Member member, Model model) throws Exception {
		model.addAttribute("member", Service.selectMember(member));
		return "user/updateForm";
	}

	// 4. 사용자 수정 내용 요청
	@PostMapping(value = "/update")
	public String userupdateForm(Member member, Model model) throws Exception {
		boolean result = Service.updete(member);
		if (result == false) {
			return "user/fail";
		}
		return "user/success";
	}

	// 4. 사용자 삭제 요청
	@GetMapping(value = "/deleteMember")
	public String userdeleteMember(Member member, Model model) throws Exception {
		boolean result = Service.deleteMember(member);
		if (result == false) {
			return "user/fail";
		}
		return "user/success";
	}

	// 5. 사용자 권한 삭제 요청
	@GetMapping(value = "/deleteAuth")
	@ResponseBody
	public Boolean userdeleteAuth(MemberAuth memberAuth, Model model) throws Exception {
		memberAuth.setUserNo(3);
		return Service.deleteAuth(memberAuth);
	}

	// 6. 사용자 정보
	@GetMapping(value = "/selectMember")
	public String userselectMember(Member member, Model model) throws Exception {
		model.addAttribute("member", Service.selectMember(member));
		return "user/selectMember";
	}
}