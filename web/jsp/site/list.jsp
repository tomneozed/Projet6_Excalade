<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 25/05/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.site.list"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<h2><s:text name="title.site.list"/></h2>

<ul>
    <s:iterator value="siteList">
        <li>
            <s:a action="site_detail">
                <s:param name="siteId" value="id"/>
                <s:property value="name"/>
            </s:a>
        </li>
    </s:iterator>
</ul>
</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
