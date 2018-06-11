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
    <title>New route</title>
</head>
<body>
    <s:actionerror />
    <s:actionmessage />

    <h2>Creation d'une voie</h2>

    <s:form action="route_new">
        <s:textfield name="route.route_number" key="route.number" requiredLabel="true" />
        <s:textfield name="route.height" key="route.height" requiredLabel="true" />
        <s:textfield name="route.grade" key="route.grade" requiredLabel="true" />
        <s:textfield name="route.anchor_count" key="route.anchor.count" requiredLabel="false" />
        <s:submit name="OK"/>
    </s:form>

</body>
</html>
