package org.tukorea.msweb.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.msweb.domain.MemberVO;
import org.tukorea.msweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public List<MemberVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}
	
	public void addMember(MemberVO member) throws Exception {
		memberDAO.add(member);
	}
	
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
	
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.update(member);
	}
	
	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 )
	public void updateMemberList(MemberVO member1, MemberVO member2) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.update(member2);
		memberDAO.update(member1);
	}

}
