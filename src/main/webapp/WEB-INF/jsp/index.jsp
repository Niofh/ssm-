
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/25
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--国际化--%>
<spring:message code="username" />


<a href="?lang=zh_CN">中文</a>

<a href="?lang=EN_US">English</a>

<form action="/user/add" method="post" enctype="multipart/form-data">
    <input type="text" value="" name="username" placeholder="请填写姓名">
    <input type="date" value="" name="birthday" placeholder="请选择日期">
    <input type="file" name="file" >
    <input type="submit" value="提交">
</form>
</body>
</html>
