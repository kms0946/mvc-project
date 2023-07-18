package org.tukorea.msweb.service;

import java.util.List;

import org.tukorea.msweb.domain.MemberVO;

public interface MemberService {
	
	public MemberVO readMember(String id) throws Exception;
	public List<MemberVO> readMemberList() throws Exception;
	public void addMember(MemberVO member) throws Exception;
	public void deleteMember(String id) throws Exception; 
	public void updateMember(MemberVO member) throws Exception;
	public void updateMemberList(MemberVO member1, MemberVO member2) throws Exception;
	
}
