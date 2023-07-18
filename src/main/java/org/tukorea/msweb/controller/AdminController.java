package org.tukorea.msweb.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.msweb.domain.AdminVO;
import org.tukorea.msweb.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
 
 	@Autowired
 	private AdminService adminService;
 	//회원가입 페이지 이동
 	@RequestMapping(value = "/join", method = RequestMethod.GET)
 	public void joinGET() {
 			
 		logger.info("회원가입 페이지 진입");
 			
 	}
 	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(AdminVO vo) throws Exception{
		
		logger.info("join 진입");
		
		// 회원가입 서비스 실행
		adminService.memberJoin(vo);
		
		logger.info("join Service 성공");
		
		return "redirect:/";
		
	}
 		
 	//로그인 페이지 이동
 	@RequestMapping(value = "/login", method = RequestMethod.GET)
 	public void loginGET() {
 			
 		logger.info("로그인 페이지 진입");
 			
 	}
 	
 	@RequestMapping(value = "/login", method = RequestMethod.POST)
 	public String login(AdminVO vo, HttpServletRequest req,RedirectAttributes rttr) throws Exception {
 	 logger.info("post login");
 	 
 	 HttpSession session = req.getSession();
 	 String mav="";
 	 AdminVO login = adminService.login(vo);
 	 
 	 if(login == null) {
 	  session.setAttribute("member", null);
 	  logger.info("로그인 실패");
 	  rttr.addFlashAttribute("msg", false);
 	  mav="redirect:/admin/login";
 	  
 	 } else {
 	  session.setAttribute("member", login);
 	  logger.info(login+"정보");
 	  logger.info("로그인 성공");
 	  mav="redirect:/member/list";
 	 }
 	 return mav;
 	}

 	
 	
 	
    	
  }
 

