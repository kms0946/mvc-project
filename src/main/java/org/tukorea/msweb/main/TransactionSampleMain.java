package org.tukorea.msweb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tukorea.msweb.config.JavaConfig;
import org.tukorea.msweb.domain.MemberVO;
import org.tukorea.msweb.service.MemberService;

public class TransactionSampleMain {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 TRANSACTION-MYBATIS");
	
//		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
//		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		
		String strID1 = "han";
		MemberVO vo1 = new MemberVO(); 
		vo1.setId(strID1); vo1.setPasswd(strID1);
		vo1.setUsername("가나다라마바사자차카타파하가나다라마바사자차카타파하");
		
		String strID2 = "han2";
		MemberVO vo2 = new MemberVO();
		vo2.setId(strID2); vo2.setPasswd(strID2); 
		vo2.setUsername(strID2);
		
		try {
			memberService.updateMemberList(vo1, vo2);
			System.out.println("TRANSACTION 처리 완료");
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
