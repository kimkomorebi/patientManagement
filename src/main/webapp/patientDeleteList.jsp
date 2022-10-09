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
						<th>ȯ���ڵ�</th>
						<td><%= pl.getP_code() %></td>
					</tr>
					<tr>
						<th>ȯ�ڸ�</th>
						<td><%= pl.getP_name() %></td>
					</tr>
					<tr>
						<th>�ּ�</th>
						<td><%= pl.getAddr() %></td>
					</tr>
					<tr>
						<th>�������</th>
						<td><%= pl.getTitle() %></td>
					</tr>
					<tr>
						<th>����ǻ�</th>
						<td><%= pl.getD_name() %></td>
					</tr>
					<tr>
						<th>���ǹ�ȣ</th>
						<td><%= pl.getRoom() %></td>
					</tr>
					<tr>
						<th>�����</th>
						<td><%= pl.getReg_date() %></td>
					</tr>
				</table><br/>
				<input type="submit" value="�����ϱ�"/>
				<input type="reset" value="�ʱ�ȭ"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>