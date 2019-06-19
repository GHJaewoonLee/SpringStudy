<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/template/header.jsp" %>

<c:if test="${userDetailInfo != null}">
	회원정보수정이 성공적으로 이루어졌습니다.<br><br>
	수정된 정보는 아래와 같습니다.<br>
	이름 : ${userDetailInfo.name}<br>
	이메일 : ${userDetailInfo.emailId}@${userDetailInfo.emailDomain}<br>
	전화번호 : ${userDetailInfo.tel1}-${userDetailInfo.tel2}-${userDetailInfo.tel3}<br>
	주소 : ${userDetailInfo.zipcode} ${userDetailInfo.address} ${userDetailInfo.addressDetail}<br>
	다시 로그인 해주세요.<br>
	<%request.getSession().invalidate();%>
	<a href='${root}/user?act=main'>메인으로</a>
</c:if>
<%@ include file="/template/footer.jsp" %>