<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.cafe.member.model.MemberDto"%>
<%
	response.sendRedirect(request.getContextPath() + "/boardadmin/boardmenu");

	MemberDto memberDto = new MemberDto();
	memberDto.setId("abcde");
	memberDto.setName("kitri");
	memberDto.setEmail("kitri@kitri.re.kr");
	session.setAttribute("userInfo", memberDto);
%>