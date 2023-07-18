package org.tukorea.msweb.service;

import javax.servlet.http.HttpSession;

import org.tukorea.msweb.domain.AdminVO;
import org.tukorea.msweb.domain.MemberVO;

public interface AdminService {
	
	public void memberJoin(AdminVO vo) throws Exception;
	
	public AdminVO login(AdminVO vo) throws Exception;
	
	
}
