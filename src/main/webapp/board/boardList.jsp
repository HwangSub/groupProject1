<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록화면</title>
</head>
<body>

<button type="button" onClick="location='write'">등록</button>

<div class="div_title">
    <table border="1" width="600">
    	<colgroup>
    		<col width="10%"/>
    		<col width="*"/>
    		<col width="15%"/>
    		<col width="15%"/>
    		<col width="20%"/>
    	</colgroup>
    	<tr>
    		<th>번호</th>
    		<th>제목</th>
    		<th>글쓴이</th>
    		<th>조회수</th>
    		<th>등록일</th>
    	</tr>
 
    	<c:forEach var="ls"  items="${datalist}">
    	<tr align="center">
    		<td>${ls.SEQID }</td>
    		<td><a href="detail/${ls.SEQID }">${ls.TITLE }</a></td>
    		<td>${ls.WRITER }</td>
    		<td>${ls.HITS }</td>
    		<td>${ls.RDATE }</td>
    	</tr>
    	</c:forEach>

    </table>
  
    
</div>
</body>
</html>






