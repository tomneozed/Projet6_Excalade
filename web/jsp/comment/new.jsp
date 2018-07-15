<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 11/07/2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.comment.new"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>

<div class="container">
    <h2><s:text name="title.comment.new"/></h2>

    <s:form action="comment_new">
        <s:textfield name="comment.text" key="comment.text" requiredLabel="true"/>
        <s:hidden name="areaId"/>
        <s:submit value="OK"/>
    </s:form>
</div>
</body>
</html>
