<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 08/06/18
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.route.new"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <s:actionerror/>
    <s:actionmessage/>

    <h2><s:text name="title.route.new"/></h2>

    <s:form action="route_new" method="POST">
        <s:textfield name="route.routeNumber" key="route.number" requiredLabel="true"/>
        <s:textfield name="route.height" key="route.height" requiredLabel="true"/>
        <s:textfield name="route.grade" key="route.grade" requiredLabel="true"/>
        <s:textfield name="route.anchorCount" key="route.anchor.count" requiredLabel="false"/>
        <s:hidden name="areaId"/>
        <s:submit value="OK"/>
    </s:form>

</div>
</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
