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
				ArrayList<DoctorList> list = (ArrayList<DoctorList>)request.getAttribute("LIST");
			%>
			<h2>의사 목록</h2>
			<table border="1">
				<tr>
					<th>의사코드</th>
					<th>의사명</th>
					<th>주소</th>
					<th>진료과목</th>
					<th>연락처</th>
				</tr>
				<%
					for(DoctorList l : list){
				%>
					<tr>
						<td><%= l.getD_code() %></td>
						<td><%= l.getD_name() %></td>
						<td><%= l.getD_addr() %></td>
						<td><%= l.getTitle() %></td>
						<td><%= l.getD_tel() %></td>
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