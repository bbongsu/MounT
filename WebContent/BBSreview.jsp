<%@page import="BBSreview.BBSreviewDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="style.css" type="text/css"
media="print, projection, screen">

<script type="text/javascript" src="jquery.tablesorter.js"></script>
<script type="text/javascript" src="jquery.tablesorter.min.js"></script>

<style type="text/css">
#sampleTable td:nth-of-type(3){
	text-align: right;
	padding-right: 0.7em;
}
#sampleTable td:nth-of-type(4){
	text-align: right;
	padding-right: 0.7em;
}
#sampleTable td:nth-of-type(5){
	text-align: right;
	padding-right: 0.7em;
}
</style>
</head>
<body>

<%
List<BBSreviewDTO> reviewList = (List<BBSreviewDTO>)request.getAttribute("reviewList");
System.out.print(reviewList.toString());
%>
<h1>후기 게시판</h1>
<table border="1" id="list_table" class="tablesorter">
<colgroup>
	<col style="width: 70px">
	<col style="width: 200px">
	<col style="width: 300px">
	<col style="width: 200px">
</colgroup>

<thead>  <!-- 동적테이블은 thead반드시 해줘야함 -->
	<tr>
		<th>번호</th>
		<th>분류</th>
		<th>글쓴이</th>
		<th>제목</th>
		<th>등록일</th>
		<th>조회</th>
	</tr>
</thead>

<tbody>
<%
if(reviewList == null || reviewList.size() == 0){
	%>	
	<tr>
		<td colspan="6" align="center">작성된 글이 없습니다</td>	
	</tr>
<%
	}else{
		
	}
	for(int i = 0;i < reviewList.size(); i++){
		BBSreviewDTO reviewDto = reviewList.get(i);
	%>	
	<tr>
			<td align="center"><%=reviewDto.getSeq() %></td>	
			<td align="center"><%=reviewDto.getMtcategory() %></td>
			<td align="center"><%=reviewDto.getId() %></td>
			<td class="title">
				<%if(reviewDto.getDel() == 1){ %>
					이 글은 작성자에 의해서 삭제되었습니다.
				<%}else{ %>
					<a href="BBSreviewDetail?seq=<%=reviewDto.getSeq() %>">
						<%=reviewDto.getTitle() %>
					</a>
				<%} %>
			</td>
			<td align="center"><%=reviewDto.getWdate() %></td>
			<td align="center"><%=reviewDto.getReadcount() %></td>
		</tr>
	<%
	}
%>
</tbody> 
</table>

<script type="text/javascript">
$(function () {	
	$("#list_table").tablesorter();
});
</script>
</body>
</html>