<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 10/06/18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Site</title>
</head>
<body>
    <s:actionerror />
    <s:actionmessage />

    <h2>Creation d'un site</h2>

    <s:form action="site_new">
        <s:textfield name="site.state" key="site.state" requiredLabel="true" />
        <s:textfield name="site.region" key="site.region" requiredLabel="true" />
        <s:textfield name="site.county" key="site.county" requiredLabel="false" />
        <s:textfield name="site.name" key="site.name" requiredLabel="true" />
        <s:submit name="OK"/>
    </s:form>


</body>
</html>
