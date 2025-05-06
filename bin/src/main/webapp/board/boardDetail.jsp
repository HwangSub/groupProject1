<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 상세화면</title>
</head>
 <script>
 function fn_delete() {
	// if( true ) { }
 	if( confirm("정말 삭제 하시겠습니까?") ) {  // 확인/취소창
		location="/b/delete/${dto.seqid}";
 	}
 }
 
 
 </script>

<body>
 <div class="div_title">
    게시판 등록화면
 </div>
 
<form name="frm" method="post" action="insert">

 <div class="div_top_button">
    <button type="button" onClick="location='/b/list'">목록</button>
    <button type="button" onClick="location='/b/modify/${dto.seqid}'">수정</button>
    <button type="button" onClick="fn_delete()">삭제</button>
 </div>

<table border="1" width="600">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="title">제목  </label></th>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<th><label for="writer">글쓴이</label></th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th><label for="content">내용</label></th>
		<td>${dto.content }</td>
	</tr>
</table>
</form>

</body>
</html>