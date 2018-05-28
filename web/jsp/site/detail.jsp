<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 26/05/18
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail site</title>
</head>
<body>

    <h2>Detail du site</h2>

    <ul>
        <li>ID : <s:property value="site.id"/> </li>
        <li>Nom : <s:property value="site.name"/> </li>
        <li>Propriétaire ID : <s:property value="site.owner_id"/> </li>
        <li>Pays : <s:property value="site.state"/> </li>
        <li>Région : <s:property value="site.region"/> </li>
        <li>Département : <s:property value="site.county"/> </li>
        <li>Date d'ajout : <s:property value="site.add_day"/> </li>
    </ul>

    <s:iterator value="areaList">
        <li>
            <s:a action="area_detail">
                <s:param name="id" value="id" />
                <s:property value="id"/>
            </s:a>
        </li>
    </s:iterator>

</body>
</html>
