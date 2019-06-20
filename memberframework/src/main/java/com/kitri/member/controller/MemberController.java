package com.kitri.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
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
			model.addAttribute("userInfo", memberDetailDto);
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
	
	@RequestMapping("/login.kitri")
	public String login() {
		return "/user/login/login";
	}
}
