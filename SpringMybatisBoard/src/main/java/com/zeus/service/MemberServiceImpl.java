package com.zeus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Board;
import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.dto.BoardDTO;
import com.zeus.mapper.BoardMapper;
import com.zeus.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	private MemberAuth memberAuth;
	private MemberAuth member;

	@Override
	@Transactional
	public boolean insert(Member member) throws Exception {
		if (member == null || member.getUserId().isEmpty()==true || member.getUserPw().isEmpty()==true) {
			return false;
		}
	
		int count = mapper.insertMember(member);

		MemberAuth  memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		int count2 = mapper.insertAuth(memberAuth);
		
		return count == 0 || count2==0 ? false : true;
	}

	@Override
	@Transactional
	public List<Member> list() throws Exception {
		return mapper.list();
	}
	@Override
	@Transactional // 변경 작업이 연속으로 일어나므로 트랜잭션 처리가 필수입니다.
	public boolean updete(Member member) throws Exception { // 1. 메서드명 오타(updete -> update) 수정
	    if (member == null) {
	        return false;
	    }

	    // 2. 회원 기본 정보 수정
	    int count = mapper.updateMember(member);
	    
	    // 3. 널 포인터 에러(NPE) 방지를 위해 임시 MemberAuth 객체 생성 후 삭제 처리
	    // (mapper.deleteAuth는 MemberAuth 타입을 원하므로, 회원의 번호(userNo)를 담아서 보냅니다)
	    MemberAuth tempAuth = new MemberAuth();
	    tempAuth.setUserNo(member.getUserNo());
	    mapper.deleteAuth(tempAuth); 
	    
	    // 4. 새로운 권한 리스트 등록
	    List<MemberAuth> authlist = member.getAuthList();
	    if (authlist != null) {
	        for (MemberAuth auth : authlist) { // 포문 변수명을 auth로 변경하여 클래스 필드와의 혼동 방지
	            if (auth.getAuth() == null || auth.getAuth().trim().length() == 0) {
	                continue;
	            }
	            auth.setUserNo(member.getUserNo());
	            mapper.insertAuth(auth);
	        }
	    }
	    
	    return count > 0;
	}

	@Override
	public boolean deleteMember(Member member) throws Exception {
		int count = mapper.deleteMember(member);
		return count == 0? false: true;
	}

	@Override
	@Transactional
	public boolean deleteAuth(MemberAuth memberAuth) throws Exception {
		int count = mapper.deleteAuth(member);
		return count == 0? false: true;
	}

	@Override
	public Member selectMember(Member member) throws Exception {
		return mapper.selectMember(member);
	}

}
