<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/template/header.jsp" %>

	<c:if test="${userInfo != null}">
		<%@ include file="/template/memberOut.jsp" %>

		<strong>${userInfo.name}(${userInfo.id})</strong>님 안녕하세요.
		<a href="${root}/user?act=logout">로그아웃</a>
		<a href="${root}/user?act=mvmodify">정보수정</a>
		<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
		<c:if test="${'java2' == userInfo.id}">
			<a href="${root}/admin?act=memberlist">관리자</a>
		</c:if>
	</c:if>
	<c:if test="${userInfo == null}">
		<c:redirect url="/user?act=mvlogin"/>
	</c:if>
		
<%@ include file="/template/footer.jsp" %>