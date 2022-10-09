<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
 ul {list-style:none; display:flex;}
</style>
</head>
<body>
	<%
		PatientList pl = (PatientList)request.getAttribute("PL");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="putPatientDelete.do" method="post">
				<input type="hidden" name="P_CODE" value="<%= pl.getP_code() %>"/>
				<input type="hidden" name="TITLE" value="<%= pl.getTitle() %>"/>
				<input type="hidden" name="D_NAME" value="<%= pl.getD_name() %>"/>
				<table border="1">
					<tr>
						<th>환자코드</th>
						<td><%= pl.getP_code() %></td>
					</tr>
					<tr>
						<th>환자명</th>
						<td><%= pl.getP_name() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%= pl.getAddr() %></td>
					</tr>
					<tr>
						<th>진료과목</th>
						<td><%= pl.getTitle() %></td>
					</tr>
					<tr>
						<th>담당의사</th>
						<td><%= pl.getD_name() %></td>
					</tr>
					<tr>
						<th>병실번호</th>
						<td><%= pl.getRoom() %></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><%= pl.getReg_date() %></td>
					</tr>
				</table><br/>
				<input type="submit" value="삭제하기"/>
				<input type="reset" value="초기화"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>