<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"/> <!-- jsp 액션태그 -->
<body>
<div align="center">
<div><h1>로그인</h1></div>
<div>
	<form action="login.jsp" method="post">
		<div>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</table>
		</div><br>
		<div>
			<input type="submit" value="로그인" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소" />
		</div>
	</form>
	<div>
		<h1>EL 표현식 테스트</h1>
	</div>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>