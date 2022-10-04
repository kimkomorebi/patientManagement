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
		ArrayList<String> tl = (ArrayList<String>)request.getAttribute("TL");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="insertDoctorInfo.do" method="post">
				<table border="1">
					<tr>
						<th>의사 코드</th>
						<td><input type="text" name="D_CODE"/></td>
					</tr>
					<tr>
						<th>의사 이름</th>
						<td><input type="text" name="D_NAME"/></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="D_ADDR"/></td>
					</tr>
					<tr>
						<th>진료과목</th>
						<td>
							<select name="TITLE">
								<%
									for(String t : tl){
								%>
									<option><%= t %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name="D_TEL"/></td>
					</tr>
				</table><br/>
				<div align="center">
					<input type="submit" value="의사 등록"/>
				</div>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>