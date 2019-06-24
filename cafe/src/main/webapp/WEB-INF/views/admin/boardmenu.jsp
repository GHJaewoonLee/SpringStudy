<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/template/top.jsp" %>
<style>
<!--
.menulist {
	width: 300px;
}

.category {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	font-weight: bold;
	text-align: left;
	background-color: #5FE4E1;
}

.menu {
	text-align: left;
	display: none;
}

.menu a {
	display: block;
	color : #B4128F;
	background-color: #CAF7F5;
	padding: 10px;
	text-decoration: none;
}

.menu a:hover {
	color : #000000;
	text-decoration: underline;
}
-->
</style>

<script>
$(document).ready(function() {
	$("#boardmenu p.category").click(function() {
		$(this).next("div.menu").slideDown("fast").siblings("div.menu").slideUp("fast");
	});
});
</script>

<div class="menulist" id="boardmenu">
	<c:set var="index" value="0"/>
	<c:forEach varStatus="i" var="board" items="${boardmenu}">
		<c:if test="${index != board.ccode}">
			<p class="category">${board.cname}</p>
			<c:set var="index" value="${board.ccode}"/>
			<div class="menu">
		</c:if>
			<a href="${root}/${board.control}/write?bcode=${board.bcode}&pg=1&key=&word=">${board.bname}</a>
		<c:if test="${i.index < boardmenu.size() - 1}">
			<c:if test="${index != boardmenu.get(i.index + 1).ccode}">
				</div>
			</c:if>
		</c:if>
	</c:forEach>
	</div>
</div>
<%@ include file="/WEB-INF/views/commons/template/bottom.jsp" %>