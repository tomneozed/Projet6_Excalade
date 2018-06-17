<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 29/05/18
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.area.list" /></title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
    <h2>Liste des secteurs</h2>

    <ul>
        <s:iterator value="areaList">
            <li>
                <s:a action="area_detail">
                    <s:param name="areaId" value="id" />
                    <s:property value="name"/>
                </s:a>
            </li>
        </s:iterator>
    </ul>

</body>
</html>
