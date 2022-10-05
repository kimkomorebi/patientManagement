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
			<h3>ȯ�� ���</h3>
			<table border="1">
				<tr>
					<th>ȯ���ڵ�</th>
					<th>ȯ�ڸ�</th>
					<th>�ּ�</th>
					<th>�������</th>
					<th>����ǻ�</th>
					<th>���ǹ�ȣ</th>
					<th>�����</th>
					<th>����</th>
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
						<td>
							<form action="patientDeleteOrUpdate" onSubmit="return check(this)" name="F">
								<input type="hidden" value="<%= l.getP_code()%>" name="P_CODE"/>
								<input type="submit" value="����" name="BTN"/>
								<input type="submit" value="����" name="BTN"/>
							</form>
						</td>
					</tr>
				<%
					}
				%>
			</table>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function check(f){
				if(! confirm("������ �����Ͻðڽ��ϱ�?")){
					return false;
				}
		}
	</script>
</body>
</html>