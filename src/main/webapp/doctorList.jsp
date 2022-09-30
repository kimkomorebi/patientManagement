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
			<table border="1">
				<tr>
					<th>�ǻ��ڵ�</th>
					<th>�ǻ��</th>
					<th>�ּ�</th>
					<th>�������</th>
					<th>�ּ�</th>
					<th>����ó</th>
				</tr>
				<%
					for(DoctorList l : list){
				%>
					<tr>
						<td><%= l.getD_code() %></td>
						<td><%= l.getD_name() %></td>
						<td><%= l.getD_addr() %></td>
						<td><%= l.getTitle() %></td>
						<td><%= l.getP_addr() %></td>
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