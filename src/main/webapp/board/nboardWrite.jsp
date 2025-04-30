<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 등록화면</title>
	<link rel="stylesheet" href="../css/style.css" />
	<!-- https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css -->
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>

  	<script>
 	$( function() {

 		$("#rdate").datepicker();
 		
 		$("#btn_list").click( function(){
 			location = "/nboardList";
 		});
 		
   		$("#btn_submit").click( function(){
   			if( $("#title").val() == "" ) {
				alert("제목을 입력하세요.");
				$("#title").focus();
				return false;
   			}
   			if( $("#pass").val() == "" ) {
				alert("암호를 입력하세요.");
				$("#pass").focus();
				return false;
   			}
   			<!-- ajax() : {비동기}전송 -->
   			let form = $("#frm").serialize();  // serialize() : 폼을 인식하는 함수
			$.ajax({
				type:"post",		// 전송 타입
				url:"/nboardInsert",// 전송 장소
				data:form,   		// 전송 데이터

   				datatype:"text", 	      // 받는 데이터 타입
   				// success : 전송에 성공한 경우
   				// let data = "ok";
   				success:function(data) {  // data변수 : 실제 받은 데이터 값
					if( data == "ok" ) {  // data변수 값이 "ok" 라면 저장 성공으로 판단함
						alert("저장완료!");
						location="/nboardList";
					} else {
						alert("저장실패!");
					}
   				},
   				// error : 전송에 실패한 경우
   				error:function(){	
					alert("전송실패!");
   				}
   			});
   		});
  	});
  	</script>
</head>

<script>

</script>

<body>
 <div class="div_title">
    게시판 등록화면
 </div>
 
<form id="frm" >

<table class="table1">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="title">제목</label></th>
		<td><input type="text" id="title" name="title" class="input1" placeholder="제목입력" autofocus></td>
	</tr>
	<tr>
		<th><label for="pass">암호</label></th>
		<td><input type="password" id="pass" name="pass" class="input1" placeholder="암호입력"></td>
	</tr>
	<tr>
		<th><label for="writer">글쓴이</label></th>
		<td><input type="text" id="writer" name="writer" class="input1"></td>
	</tr>
	
	<tr>
		<th><label for="rdate">날짜</label></th>
		<td><input type="text" id="rdate" name="rdate" class="input1"></td>
	</tr>
	
	<tr>
		<th><label for="emsis">강조</label></th>
		<td style="text-align:left;">
		&nbsp;<input type="checkbox" id="emsis" name="emsis" value="Y"></td>
	</tr>
	
	<tr>
		<th><label for="content">내용</label></th>
		<td><textarea id="content" name="content" class="textarea1"></textarea></td>
	</tr>
</table>

 <div class="div_button_area">
    <button type="submit" id="btn_submit">저장</button>
    <button type="reset">취소</button>
    <button type="button" id="btn_list">목록</button>
 </div>
 
</form>

</body>
</html>