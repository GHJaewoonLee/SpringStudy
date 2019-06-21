package com.kitri.admin.model.service;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.admin.model.dao.AdminDao;
//import com.kitri.admin.model.dao.AdminDaoImpl;
import com.kitri.member.model.MemberDetailDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String getMemberList(Map<String, String> map) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("key", key);
//		map.put("word", word);
		
		List<MemberDetailDto> list = adminDao.getMemberList(map);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray(list);
//		String result = "<?xml version='1.0' encoding='utf-8'?>\n";
//		result += "<memberlist>\n";
//		for (MemberDetailDto memberDetailDto : list) {
//			result += "	<member>\n";
//			result += "		<id>" + memberDetailDto.getId() + "</id>\n";
//			result += "		<name>" + memberDetailDto.getName() + "</name>\n";
//			result += "		<email>" + memberDetailDto.getEmailId() + "@" + memberDetailDto.getEmailDomain() + "</email>\n";
//			result += "		<tel>" + memberDetailDto.getTel1() + "-" + memberDetailDto.getTel2() + "-" + memberDetailDto.getTel3() + "</tel>\n";
//			result += "		<address><![CDATA[" + memberDetailDto.getAddress() + " " + memberDetailDto.getAddressDetail() + "]]></address>\n";
//			result += "		<joindate>" + memberDetailDto.getJoindate() + "</joindate>\n";
//			result += "	</member>\n";
//		}
//		result += "</memberlist>";
		json.put("memberlist", jarray);
		
		return json.toString();
	}
}
