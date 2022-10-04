<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> titleList = (ArrayList<String>)request.getAttribute("TL");
		ArrayList<String> doctorList = (ArrayList<String>)request.getAttribute("DL");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="insertPatientInfo.do" method="post">
				<table border="1">
					<tr>
						<th>ȯ�� �ڵ�</th>
						<td><input type="text" name="P_CODE"/></td>
					</tr>
					<tr>
						<th>ȯ�� �̸�</th>
						<td>
							<input type="text" name="P_NAME"/>
						</td>
					</tr>
					<tr>
						<th>�ּ�</th>
						<td>
							<input type="text" name="ADDR"/>
						</td>
					</tr>
					<tr>
						<th>���� ����</th>
						<td>
							<select name="M_CODE">
								<%
									for(String tl : titleList){
								%>
									<option><%= tl %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>��� �ǻ�</th>
						<td>
							<select name="D_NAME">
								<%
									for(String dl : doctorList){
								%>
									<option><%= dl %></option>							
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>���� ��ȣ</th>
						<td>
							<input type="text" name="ROOM"/>
						</td>
					</tr>
				</table><br/>
				<div align="center">
					<input type="submit" value="ȯ�� ���� ����ϱ�"/>
					<input type="button" value="���"/>
				</div>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>