package org.tukorea.msweb.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.msweb.domain.AdminVO;
import org.tukorea.msweb.domain.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sql;
	
	private static final String namespace = "org.tukorea.msweb.mapper.memberMapper";
	
	@Override
	public void memberJoin(AdminVO vo) throws Exception{
		sql.insert(namespace+ ".register",vo);
	}
	
	@Override
	public AdminVO login(AdminVO vo) throws Exception{
		return sql.selectOne(namespace+".login",vo);
	}

}
