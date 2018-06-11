<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 09/06/18
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Area</title>
</head>
<body>

    <s:actionerror />
    <s:actionmessage />

    <h2>Creation d'un secteur</h2>

    <s:form action="area_new">
        <s:textfield name="area.name" key="area.name" requiredLabel="true" />
        <s:textfield name="area.type" key="area.type" requiredLabel="true" />
        <s:select name="area.type" key="area.type"
                  list="typeList"
                  emptyOption="true"
                  requiredLabel="true"/>
        <s:textfield name="area.description" key="area.description" requiredLabel="false" />
        <s:submit name="OK"/>
    </s:form>

    <s:a action="route_new">Ajouter une voie</s:a>

</body>
</html>
