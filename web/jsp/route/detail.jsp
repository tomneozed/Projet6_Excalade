<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 04/06/18
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><s:text name="title.route.detail" /></title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
<h2><s:text name="title.route.detail" /></h2>

<ul>
    <li><s:text name="route.id" /><s:property value="route.id"/> </li>
    <li><s:text name="route.area.id" /><s:property value="route.areaId"/> </li>
    <li><s:text name="route.number" /><s:property value="route.routeNumber"/> </li>
    <li><s:text name="route.height" /><s:property value="route.height"/> </li>
    <li><s:text name="route.grade" /><s:property value="route.grade"/> </li>
    <li><s:text name="route.anchor.count" /><s:property value="route.anchorCount"/> </li>
</ul>

</body>
</html>
