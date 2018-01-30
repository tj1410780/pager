<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>

<script type="text/javascript">
 var currentPage = ${result.curentPage};
 var totalPage = ${result.totalPage};
 
 function submitForm(actionUrl) {
	// var formElement = document.getElementById("stuForm");
	var formElement = $('#stuForm');
	formElement.action = actionUrl;
	formElement.submit();
 }
 //第一页
 function firstPage() {
	 if (currentPage == 1) {
		 alert("已经是第一页数据");
		 return false;
	 } else {
		 submitForm("/student/search?currentPage=1");
		 return true;
	 }
 }
 //下一页
 function nextPage() {
	 if (currentPage == totalPage) {
		 alert("已经是最后一页数据");
		 return false;
	 } else {
		 submitForm("/student/search?currentPage=" + (currentPage + 1));
		 return true;
	 }
 }
 
 //上一页
 function previousPage() {
	 if (currentPage == 1) {
		 alert("已经是第一页数据");
		 return false;
	 } else {
		 submitForm("/student/search?currentPage=" + (currentPage - 1));
		 return true;
	 }
 }
 
 function lastPage() {
	 if (currentPage == totalPage) {
		 alert("已经是最后一页数据");
		 return false;
	 } else {
		 submitForm("/student/search/currentPage=" + totalPage);
	 }
 }
</script>


<body>
<div style="margin-left:100px;margin-top:100px;">
<form action= "/student/search" id="stuForm" method="post">
姓名：<input type="text" name="name">
性别：<input type="text" name="gender">
<input type="submit" value="提交"><br>
学生信息列表：<br>
<br>
<!-- 后台返回结果为空 -->
	<c:if test="${fn:length(result.dataList) eq 0}">
		<span>查询的结果不存在</span>
	</c:if>
	
<!-- 后台返回结果不为空 -->
	<c:if test="${fn:length(result.dataList) gt 0}">
		<table border="1px" cellspacing="0px"
			style="border-collapse:collapse">
		<thead>
			<tr height="30">
				<th width="130">姓名</th>
				<th width="130">年龄</th>
				<th width="130">性别</th>
				<th width="190">地址</th>
			</tr>
		</thead>
	<c:forEach var="student" items="${result.dataList}">
		<tr>
			<td>"${student.name}"</td>
			<td>"${student.age}"</td>
			<td>"${student.gender}"</td>
			<td>"${student.address}"</td>
		</tr>
	</c:forEach>
</table>
<br>共${result.totalRecord}条记录共${result.toatalPage}页&nbsp;&nbsp;当前第${result.currentPage}页&nbsp;&nbsp;
<a href="#" onclick="firstPage()">首页</a>&nbsp;&nbsp;
<a href="#" onclick="nextPage()">下一页</a>&nbsp;&nbsp;
<a href="#" onclick="previousPage()">上一页</a>&nbsp;&nbsp;
<a href="#" onclick="lastPage()">尾页</a>&nbsp;&nbsp;
</c:if>

</form>
</div>
</body>
</html>