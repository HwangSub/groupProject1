<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>암호 등록 화면 입니다.</title>
	<link rel="stylesheet" href="../css/style.css" />
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>

  	<script>
 	$( function() {

 		$("#btn_list").click( function(){
 			location = "/nboardList";
 		});
 		
   		$("#btn_submit").click( function(){
   			
   			if ( $("#pass").val() == "" ) {
				alert("암호를 입력하세요.");
   				$("#pass").focus();
   				return false;
   			}
   			
   			let form = $("#frm").serialize();  // serialize() : 폼을 인식하는 함수
   			$.ajax({
				type:"post",		// 전송 타입
				url:"/nboardDelete",// 전송 장소
				data:form,   		// 전송 데이터
   				datatype:"text", 	// 받는 데이터 타입
   				success:function(data) {  
					if( data == "1" ) {   
						alert("삭제 성공!");
						location="/nboardList";
					} else if( data == "2" ) {
						alert("암호를 잘못 입력했습니다.!");
					} else {
						alert("삭제 실패!");
					}
   				},
   				error:function(){	
					alert("전송 실패!");
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
    암호 입력 화면 입니다.
 </div>
 
<form id="frm" >
	
	<input type="hidden" name="seqid" value="${seqid }">
	
<table class="table1">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="pass">암호</label></th>
		<td><input type="password" id="pass" name="pass" class="input1" placeholder="암호입력"></td>
	</tr>
</table>

 <div class="div_button_area">
    <button type="submit" id="btn_submit" onclick="return false;">삭제</button>
    <button type="reset">취소</button>
    <button type="button" id="btn_list">목록</button>
 </div>
 
</form>

</body>
</html>