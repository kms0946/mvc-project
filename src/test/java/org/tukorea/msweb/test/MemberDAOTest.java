package org.tukorea.msweb.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.msweb.domain.MemberVO;
import org.tukorea.msweb.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {
	@Autowired
	private MemberDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		MemberVO vo;
		vo = dao.read("han");
		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<MemberVO> voList;
		voList = dao.readList();
		for(MemberVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
