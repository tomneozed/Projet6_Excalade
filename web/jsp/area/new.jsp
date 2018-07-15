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
    <title><s:text name="title.area.new"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>

<div class="container">
    <s:actionerror/>
    <s:actionmessage/>

    <h2>Creation d'un secteur</h2>

    <s:form action="area_new">
        <s:textfield name="area.name" key="area.name" requiredLabel="true"/>
        <s:select name="area.type" key="area.type"
                  list="typeList"
                  emptyOption="true"
                  requiredLabel="true"/>
        <s:textfield name="area.description" key="area.description" requiredLabel="false"/>
        <s:hidden name="siteId"/>
        <s:hidden name="areaId"/>
        <s:submit value="OK"/>
    </s:form>
</div>


</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
