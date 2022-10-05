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
		ArrayList<String> dl = (ArrayList<String>)request.getAttribute("DL");
		ArrayList<String> tl = (ArrayList<String>)request.getAttribute("TL");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="putPatientUpdate.do" method="post">
				<table border="1">
					<tr>
						<th>환자코드(변경불가)</th>
						<td><input type="text" value="<%= pl.getP_code() %>" name="P_CODE" readOnly="readOnly"/></td>
					</tr>
					<tr>
						<th>환자명</th>
						<td><input type="text" name="P_NAME" value="<%= pl.getP_name() %>"/></td>
					</tr>
					<tr>
						<th>환자주소</th>
						<td><input type="" name="ADDR" value="<%= pl.getAddr() %>"/></td>
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
						<th>담당의사</th>
						<td>
							<select name="D_NAME">
								<%
									for(String d : dl){
								%>
									<option><%= d %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>병실번호</th>
						<td><input type="text" name="ROOM" value="<%= pl.getRoom() %>"/></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><input type="text" name="DATE" value="<%= pl.getReg_date() %>"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="수정하기"/>
				<input type="reset" value="초기화"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>