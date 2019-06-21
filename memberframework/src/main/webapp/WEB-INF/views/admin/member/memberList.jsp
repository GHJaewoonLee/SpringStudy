<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/template/header.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			memberList('', '');
			
			$("#searchBtn").click(function() {
				var key = $("#key").val();
				var word = $("#word").val();
				$("#word").val('');
				memberList(key, word);				
			});
		});
		
		function memberList(key, word) {
			$("#mlist").empty();
			$.ajax({
				type : "get",
				url : "${root}/admin/memberlist.kitri", 
				dataType : "json",
				data : {"key" : key, "word" : word},
				timeout : 30000,
				cache : false,
				success : function(data) {
					var member = data.memberlist;
					var len = member.length;
					var view = "";
					
					for (var i = 0; i < member.length; i++) {
						view += "<tr class='table-active'>\n";
						view += ("<td>" + member[i].id + "</td>"); 
						view += ("<td>" + member[i].name + "</td>"); 
						view += ("<td>" + member[i].emailId + "@" + member[i].emailDomain + "</td>"); 
						view += ("<td>" + member[i].tel1 + "-" + member[i].tel2 + "-" + member[i].tel3 + "</td>"); 
						view += ("<td>" + member[i].address + " " + member[i].addressDetail + "</td>"); 
						view += ("<td>" + member[i].joindate + "</td>"); 
						view += "</tr>\n"
	
						$("#mlist").empty().append(view);
					}
				}
			});
		}
	</script>
		<div class="table-responsive-lg">
			<h2>회원목록</h2>
			<table class="table">
				<tr>
					<td>
						<form class="form-inline" action="">
							<select class="form-control" id="key" name="key">
								<option value="id">아이디</option>
								<option value="tel3">전화번호 뒷자리</option>
								<option value="address">주소</option>
							</select> <input type="text" class="form-control" id="word" name="word">
							<button type="button" id="searchBtn" class="btn btn-primary">검색</button>
						</form>
					</td>
				</tr>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody id="mlist"></tbody>
			</table>
		</div>
		
<%@ include file="/WEB-INF/views/template/footer.jsp"%>