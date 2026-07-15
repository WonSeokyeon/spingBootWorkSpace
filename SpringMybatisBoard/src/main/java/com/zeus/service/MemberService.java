package com.zeus.service;

import java.util.List;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;


public interface MemberService {
	
	//insert
	public boolean insert(Member member) throws Exception;
	
	//list
	public List<Member> list() throws Exception;
	
	//update
	public boolean updete(Member member) throws Exception;
	
	//delete
	public boolean deleteMember(Member member) throws Exception;
	
	//delete Auth
	public boolean deleteAuth(MemberAuth memberAuth) throws Exception;
	
	//delete select
	public Member selectMember(Member member) throws Exception;
	
}
