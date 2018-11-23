<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="layui/css/layui.css">
	<script type="text/javascript" src="layui/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
  </head>
  
  <body>
   <table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>userid</th>
      <th>username</th>
      <th>userpassword</th>
      <th>sex</th>
      <th>phone</th>
      <th>photo</th>
    </tr> 
  </thead>
  <tbody>
  <c:forEach items="${list }" var="m">
    <tr>
      <td>${m.userid }</td>
      <td>${m.username }</td>
      <td>${m.userpassword }</td>
      <td>${m.sex }</td>
      <td>${m.phone }</td>
      <td><img src="/upload/${m.photo }"/></td>
      <td><form action="demo/upload.do?userid=${m.userid }" enctype="multipart/form-data" method="post">
  	 	文件：<input type="file" name="photos"/><br/>
  	 	<input type="submit"/>
  	 </form></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
  </body>
</html>
