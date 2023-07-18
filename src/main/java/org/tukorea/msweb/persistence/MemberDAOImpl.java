package org.tukorea.msweb.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tukorea.msweb.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.msweb.mapper.memberMapper";

	public MemberVO read(String id) throws Exception {
	
		MemberVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
 
	public List<MemberVO> readList() throws Exception {
		List<MemberVO> memberlist = new ArrayList<MemberVO>();
		memberlist = sqlSession.selectList(namespace + ".selectAll");
		return memberlist;
	}
	
	public void add(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}

	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", id);
	}

	public void update(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", member);
	}
	

}
