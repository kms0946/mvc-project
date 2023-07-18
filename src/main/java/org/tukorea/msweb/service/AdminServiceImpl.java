package org.tukorea.msweb.service;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.msweb.domain.AdminVO;
import org.tukorea.msweb.domain.MemberVO;
import org.tukorea.msweb.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private static Hashtable<String, String> loginUsers = new Hashtable<String, String>();
	
	@Override
	public void memberJoin(AdminVO vo) throws Exception{
		dao.memberJoin(vo);
	}
	
	@Override
	public AdminVO login(AdminVO vo) throws Exception {
		return dao.login(vo);
    }

	

}
