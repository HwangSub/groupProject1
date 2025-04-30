<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>암호 등록 화면</title>
	<link rel="stylesheet" href="../css/style.css" />
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
  	
  	<script>
 	$( function() {
 		// 화면넓이을 얻어냄
 		let b_width = window.innerWidth; 
 		// 기본URL:댓글삭제
 		let url = "reboardDelete";
 		// 출력화면의 넓이로 댓글과 본글 삭제를 구별한다.
 		if( b_width >= 500 ) {
			//본글삭제
			url = "myboardDelete";
 		}
 		
   		$("#btn_submit").click( function(){
   			if ( $("#pass").val() == "" ) {
				alert("암호를 입력하세요.");
   				$("#pass").focus();
   				return false;
   			}

   			let form = $("#frm").serialize();  // serialize() : 폼을 인식하는 함수
   			$.ajax({
				type:"post",		 // 전송 타입
				url:"/"+url,		 // 전송 장소
				data:form,   		 // 전송 데이터
   				datatype:"text", 	 // 받는 데이터 타입
   				success:function(data) {  
					if( data == "1" ) {   
						alert("삭제 성공!");
						
						if( b_width >= 500 ) {
							location = "/myboardList";
						} else {
							opener.location.reload();
							self.close();
						}
					} else if( data == "2" ) {
						alert("암호를 잘못 입력했습니다.!");
					} else if( data == "3" ) {
						alert("하위 댓글이 존재하여 코맨트만 비웠습니다.");
					} else {
						alert("삭제 실패!");
					}
   				},
   				error:function(){	
					alert("오류발생!");
   				}
   			});
   		});
  	});
  	</script>
</head>

<script>

</script>

<body>
 <div class="div_title" style="width:300px;">
    암호 입력 화면
 </div>
 
<form id="frm" >
	
	<input type="hidden" name="seqid" value="${seqid }">
	
<table class="table1" style="width:300px;">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="pass">암호</label></th>
		<td><input type="password" id="pass" name="pass" class="input1" placeholder="암호입력"></td>
	</tr>
</table>

 <div class="div_button_area" style="width:300px;">
    <button type="submit" id="btn_submit" onclick="return false;">삭제</button>
    <button type="button" id="btn_list" onclick="self.close();">닫기</button>
 </div>
 
</form>

</body>
</html>