package org.tukorea.msweb.controller;

import java.util.List;

import org.tukorea.msweb.domain.MemberVO;
import org.tukorea.msweb.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
    private MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping("/list")
    public String listMember(Model model) throws Exception {
    	List<MemberVO> members = memberService.readMemberList();
    	
		logger.info(" /member/list URL called. then listMemebr method executed.");
        model.addAttribute("members", members);
        return "member/member_list";
    }
    
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
    	MemberVO member = memberService.readMember(id);
    	
		logger.info(" /read?id=? URL called. then readMemebr method executed.");
        model.addAttribute("member", member);
        return "member/member_read";
    }
    
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String createMemberGet() throws Exception {
		logger.info(" /register URL GET method called. then forward member_register.jsp.");
		return "member/member_register";
	}
	
    
	@PostMapping("/register")
	public String createMemberPost( @ModelAttribute("member") MemberVO vo) throws Exception {
		memberService.addMember(vo);
		logger.info(vo.toString());
		logger.info(" /register URL POST method called. then createMember method executed.");
		return "redirect:/member/list";
	}
	
            
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception {
    	MemberVO member = memberService.readMember(id);
    	
		logger.info(" /modify?id=? URL GET method called. then forward member_modify.jsp.");
        model.addAttribute("member", member);
        return "member/member_modify";
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMemberPost(@ModelAttribute("member") MemberVO vo) throws Exception {
    	memberService.updateMember(vo);
		logger.info(vo.toString());
		logger.info(" /modify?id=? URL POST method called. then modifyMemberPost method executed.");
        return "redirect:/member/list";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteMember(@RequestParam String id) throws Exception {
    	memberService.deleteMember(id);
		logger.info(" /delete?id=? URL POST method called. then deleteMemberPost method executed.");
        return "redirect:/member/list";
    }
   
}