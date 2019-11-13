<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 톰캣이 해주던 시스템
	// ㅋㅋㅋ - 인코딩 -> 1111 - 서버로 전송 -> 1111 - 디코딩 -> ㅋㅋㅋ
	
	// 톰캣의 기존 방식은 파일처리를 할줄모름
	// cos.jar의 방식으로 위작업을 해야함.
%>

	<h1>파일 업로드1</h1>
	
	<!-- enctype="multipart/form-data" 톰캣의 방식을 쓰지않겠다 -->
	<form action="file.upload" enctype="multipart/form-data" method="post">
		제목 : <input name="title"><br>
		파일 : <input name="photo" type="file"><br>
		<button>업로드</button>
	</form>

</body>
</html>