<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원수정화면</title>
	<link rel="stylesheet" href="../css/style.css"></link>
</head>
 <script>
  function fn_submit() {
	
	   let f = document.frm;
	   if (f.userid.value == "" ){
			alert("아이디를 입력해주세요.");
			f.userid.focus();
			return false;
	   }
	   if (f.pass.value == "" ){
			alert("암호를 입력해주세요.");
			f.pass.focus();
			return false;
	   }
	   f.submit();
  }
 </script>

<body>

<div>
<form name="frm" method="post" action="/mbrUpdate">
	<table class="table1">
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" name="userid" id="userid" value="${dto.userid }" class="input1" readonly>
			</td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="text" name="pass" id="pass" class="input1"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" value="${dto.name }" class="input1"></td>
		</tr>
		<tr>
			<th>핸드폰 </th>
			<td><input type="text" name="phone" id="phone" value="${dto.phone }" class="input1"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="M" class="radio1"    
				<c:if test="${dto.gender=='남'}">checked</c:if> > 남
				<input type="radio" name="gender" value="F" class="radio1"   
				<c:if test="${dto.gender=='여'}">checked</c:if> > 여
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="addr" id="addr" value="${dto.addr }" class="input1"></td>
		</tr>
	</table>
	
	<div class="div_button_area">
		<button type="submit" onClick="fn_submit();return false;">저장</button>
		<button type="reset">취소</button>
	</div>

</form>

</div>

</body>
</html>




