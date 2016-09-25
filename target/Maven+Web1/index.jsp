<%@ page language="java" import="java.util.*,java.text.*,java.lang.String,rq.*" pageEncoding="utf-8"%>
<%@ page import="rq.TestDemo" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>第一个jsp页面</title>
</head>

<body>
<%
    String helloString = "asdasd123";
    //String helloString = TestDemo.show();
%>

<%=helloString %>
</body>
</html>
