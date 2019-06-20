package com.kitri.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.member.model.dao.MemberDao;


// using singleton pattern

// 1. create private constructor method
// 2. create static global variable
// 3. create static method (initiate)
// 4. create getter method

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	// text, XML, JSON
	@Override
	public String idcheck(String id) {
		int cnt = memberDao.idcheck(id);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		return json.toString();
	}

	@Override
	public String zipSearch(String doro) {
		List<ZipcodeDto> list = memberDao.zipSearch(doro);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray(list);
		//JSONArray jarray = new JSONArray();
		//for (ZipcodeDto zipcodeDto : list) {
		//	JSONObject zipcode = new JSONObject();
		//	zipcode.put("zipcode", zipcodeDto.getZipcode());
		//	zipcode.put("address", zipcodeDto.getSido() + " " + zipcodeDto.getGugun() + " " + zipcodeDto.getUpmyon() + " " + zipcodeDto.getDoro() + " " + zipcodeDto.getBuildingNumber() + " " + zipcodeDto.getSigugunBuildingName());
		//	jarray.put(zipcode);
		//}
		json.put("ziplist", jarray);
		//System.out.println(json.toString());
		return json.toString();
	}
	// {"ziplist" : [{"zipcode" : "", "address" : ""}, {"zipcode" : "", "address" : ""}, {"zipcode" : "", "address" : ""}, ...]}

	@Override
	public int registerMember(MemberDetailDto memberDetialDto) {
		return memberDao.registerMember(memberDetialDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		
		return memberDao.loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetialDto) {
		return memberDao.modifyMember(memberDetialDto);
	}

	@Override
	public int deleteMember(String id) {
		return memberDao.deleteMember(id);
	}
}
