package com.kitri.member.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
@SessionAttributes("userInfo")
//@SessionAttributes(names = {"userInfo", "registerInfo", ...})
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("Impl")
	private MemberService memberService;
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET)
	public String register() {
		return "user/member/member";
	}
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)
	public String register(MemberDetailDto memberDetailDto, Model model) {
		int cnt = memberService.registerMember(memberDetailDto);
		if (cnt != 0) {
			model.addAttribute("registerInfo", memberDetailDto);
			return "user/member/registerOK";
		}
		return "user/member/registerFail";
	}
	
	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
		//logger.info("검색 ID : " + id);
		String json = memberService.idcheck(id);
		return json;
	}
	
	@RequestMapping(value = "/zipsearch.kitri")
	@ResponseBody
	public String zipSearch(@RequestParam("doro") String doro) {
		//logger.info("검색 ID : " + doro);
		String json = memberService.zipSearch(doro);
		return json;
	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.GET)
	public String login() {
		return "/user/login/login";
	}
	
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if (memberDto != null) {
//			session.setAttribute("userInfo", memberDto);
//			return "user/login/loginOK";
//		} else {
//			return "user/login/loginFail";
//		}
//	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model) {
		MemberDto memberDto = memberService.loginMember(map);
		if (memberDto != null) {
			model.addAttribute("userInfo", memberDto);
			return "user/login/loginOK";
		} else {
			return "user/login/loginFail";
		}
	}
	
//	@RequestMapping("/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		
//		return "redirect:/index.jsp";
//	}
	
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
}
