<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>다운로드 게시판 목록 화면</title>
	<link rel="stylesheet" href="../css/style.css" />

	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
</head>
	
	<script>
	$(function(){
		$("#btn_write").click(function(){
			location = "/dataWrite";
		});
	});
	</script>

<body>

 <div class="div_title">
    자료 게시판 목록
 </div>
 
 <div>
 	Total : ${total}
 </div>
	<table class="table1">
    	<colgroup>
    		<col width="7%"/>
    		<col width="*"/>
    		<col width="10%"/>
    		<col width="7%"/>
    		<col width="12%"/>
    		<col width="15%"/>
    	</colgroup>
    	<tr>
    		<th>번호</th>
    		<th>제목</th>
    		<th>글쓴이</th>
    		<th>조회수</th>
    		<th>등록일</th>
    		<th>파일</th>
    	</tr>

    	<c:forEach var="result" items="${resultList}"  >
    	<tr>
    		<td>${pageRownum }</td>
	    	<td style="text-align:left;"> 
	   <a href="/dataDetail/${result.SEQID}">${result.TITLE} </a> 
	   		</td>
	    	<td>${result.WRITER}</td>
	    	<td>${result.HITS}</td>
	    	<td>${fn:substring(result.RDATE,0,10)}</td>
	    	<td style="text-align:left;">
	    		&nbsp;
	    		<c:set var="filename" value="${fn:trim(result.FILENAME)}" />
	    		
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
    		<c:set var="pageRownum" value="${pageRownum-1 }" />
    	</c:forEach>

    </table>
    
    <div class="div_button_area">
    	<c:forEach var="p" begin="1" end="${totalPage}">
    	
    		<a href="/dataList?pageIndex=${p }">${p }</a>
    	
    	</c:forEach>
    </div>
    
    <div>
    	<button type="button" id="btn_write">글쓰기</button>
    </div>
    
    
</body>
</html> 






	
    	