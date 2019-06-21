<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/template/header.jsp" %>

	<c:if test="${userInfo != null}">
		세션 O
	</c:if>
	<c:if test="${userInfo == null}">
		세션 X
	</c:if>
		
<%@ include file="/WEB-INF/views/template/footer.jsp" %>