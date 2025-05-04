<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자료 게시판 상세화면</title>
	<link rel="stylesheet" href="../css/style.css" />
	<script src="../js/jquery-3.7.1.js"></script>
</head>

<script>

$(function(){
	$("#btn_before").click(function(){
		if( ${dto.bseqid} > 0 ) {
			location = "/dataDetail/${dto.bseqid}";
		} else {
			alert("이전 내용이 없습니다.");
		}
	});
	$("#btn_next").click(function(){
		if(  ${dto.nseqid} > 0  ) {
			location = "/dataDetail/${dto.nseqid}";
		} else {
			alert("다음 내용이 없습니다.");
		}
	});
	
	$("#btn_list").click(function(){
		location = "/dataList";
	});
	$("#btn_modify").click(function(){
		location = "/dataModify/${dto.seqid}";
	});
	$("#btn_delete").click(function(){
		location = "/passWrite/${dto.seqid}";
	});
	
});

</script>

<style>
 .table1 td {
 	text-align:left;
 }
 .div_content {
 	width:98%;
 	height:120px;
 }
</style>

<body>
 <div class="div_title">
    자료 게시판 상세화면 222
 </div>
 
<form id="frm" >

<table class="table1">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="title">제목222</label></th>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<th><label for="writer">글쓴이</label></th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th><label for="content">내용</label></th>
		<td><div class="div_content">${dto.content }</div></td>
	</tr>
	<tr>
		<th><label for="rdate">등록일</label></th>
		<td>${fn:substring(dto.rdate,0,10) }</td>
	</tr>
	<tr>
		<th><label for="udate">변경일</label></th>
		<td>${fn:substring(dto.udate,0,10) }</td>
	</tr>
	<tr>
		<th>자료</th>
		<td>
			&nbsp;
    		<c:set var="filename" value="${fn:trim(dto.filename)}" />
    		
    		<c:if test="${filename != ''}">
				<c:set var="files" value="${fn:split(filename,'／')}" /> 		

				<c:forEach var="i" begin="0" end="${fn:length(files)-1 }">
				<a href="/data/${files[i] }">
					<img src="/images/icon/download.PNG" width="20" height="20">
				</a>
				</c:forEach>
    		</c:if>
		</td>
	</tr>
</table>

 <div class="div_button_area">
    <button type="button" id="btn_before" >이전</button>
    <button type="button" id="btn_next" >다음</button>
 	 &nbsp;
    <button type="button" id="btn_list" >목록</button>
    <button type="button" id="btn_modify">수정</button>
    <button type="button" id="btn_delete">삭제</button>
 </div>
 
</form>

</body>
</html>