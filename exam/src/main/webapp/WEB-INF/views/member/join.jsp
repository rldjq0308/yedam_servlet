<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원가입</h1>
		</div>
		<form action="memberjoin.do" method="post" id="frm" onsubmit="return formCheck()">
			<div>
				<table border="1">
					<tr>
						<th>아이디*</th>
						<td><input type="text" id="id" name="id" required="required"/>
						<button type="button" id="btn" value="no" onclick="idCheck()">중복체크</button></td>
						
					</tr>
					<tr>
						<th>비밀번호*</th>
						<td><input type="password" id="pw" name="pw" required="required"/></td>
					</tr>
					<tr>
						<th>비밀번호 확인*</th>
						<td><input type="password" id="pwchk" name="pwchk" required="required"/></td>
					</tr>
					<tr>
						<th>이름*</th>
						<td><input type="text" id="name" name="name" required="required"/></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" id="tel" name="tel"/></td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="회원가입" />
				<input type="reset" value="취소" />
			</div>
		</form>
	</div>
	<script type="text/javascript">
	function idCheck(){
		let id = document.getElementById('id').value;
		let url = "idcheck.do?id="+id;
		
		fetch(url)
			.then(response=>response.text())
			.then(text => checkId(text));
	}
	function checkId(text){
		if(text == 'yes'){
			alert("사용 가능한 아이디 입니다.");
			document.getElementById('btn').disabled = true;
			document.getElementById('btn').value = "Yes";
			document.getElementById('pw').focus();
		}else{
			alert("이미 사용하는 아이디 입니다.");
			document.getElementById('id').value ="";
			document.getElementById('id').focus();
		}
	}
	
	function formCheck(){
		let password = document.getElementById('pw').value;
		let passcheck = document.getElementById('pwchk').value;
		let id = document.getElementById('btn').value;
		
		if(id == 'no'){
			alert("아이디 중복체크를 하세요!!!!");
			return false;
		}
		
		if(password != passcheck){
			alert("패스워드가 일치하지 않습니다.");
			return false;
		}
		
		return true;
		
	}
	</script>
</body>
</html>