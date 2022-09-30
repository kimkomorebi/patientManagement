<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<%
				ArrayList<PatientList> list = (ArrayList<PatientList>)request.getAttribute("LIST");
			%>
			<h3>환자 목록</h3>
			<table border="1">
				<tr>
					<th>환자코드</th>
					<th>환자명</th>
					<th>주소</th>
					<th>진료과목</th>
					<th>담당의사</th>
					<th>병실번호</th>
					<th>등록일</th>
					<th>삭제</th>
				</tr>
				<%
					for(PatientList l : list){
				%>
					<tr>
						<td><%= l.getP_code()%></td>
						<td><%= l.getP_name() %></td>
						<td><%= l.getAddr() %></td>
						<td><%= l.getTitle() %></td>
						<td><%= l.getD_name() %></td>
						<td><%= l.getRoom() %></td>
						<td><%= l.getReg_date() %></td>
						<td>삭제</td>
					</tr>
				<%
					}
				%>
			</table>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>