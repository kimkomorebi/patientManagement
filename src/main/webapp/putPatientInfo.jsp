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
						<th>환자 코드</th>
						<td><input type="text" name="P_CODE"/></td>
					</tr>
					<tr>
						<th>환자 이름</th>
						<td>
							<input type="text" name="P_NAME"/>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" name="ADDR"/>
						</td>
					</tr>
					<tr>
						<th>진료 과목</th>
						<td>
							<select name="TITLE">
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
						<th>담당 의사</th>
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
						<th>병실 번호</th>
						<td>
							<input type="text" name="ROOM"/>
						</td>
					</tr>
				</table><br/>
				<div align="center">
					<input type="submit" value="환자 정보 등록하기"/>
					<input type="button" value="취소"/>
				</div>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>