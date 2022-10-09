<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String result = request.getParameter("R");
	if(result.equals("Y")){
%>
	<script type="text/javascript">
		alert("환자 진료 정보 삭제 완료!");
	</script>
<%
	}else if(result.equals("N")){
%>
	<script type="text/javascript">
		alert("환자 진료 정보 삭제 실패ㅠㅜ");
	</script>
<%	
	}
%>
<script type="text/javascript">
	location.href="patientList.do";
</script>
</body>
</html>