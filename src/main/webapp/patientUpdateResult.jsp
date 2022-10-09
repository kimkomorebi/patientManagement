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
			alert("환자 정보 수정에 성공하였습니다.");
		</script>
	<%		
		}else if(result.equals("N")){
	%>
		<script type="text/javascript">
			alert("환자 정보 수정에 실패하였습니다 관리자에게 문의해 주세요.");
		</script>
	<%		
		}
	%>
	<script type="text/javascript">
		location.href = "patientList.do";
	</script>
</body>
</html>