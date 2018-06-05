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
    <title>Title</title>
</head>
<body>
<h2>Detail des voies</h2>

<ul>
    <li>ID : <s:property value="route.id"/> </li>
    <li>ID secteur : <s:property value="route.area_id"/> </li>
    <li>Numéro de voie : <s:property value="route.route_number"/> </li>
    <li>Hauteur : <s:property value="route.height"/> </li>
    <li>Cotation : <s:property value="route.grade"/> </li>
    <li>Nombre de splits : <s:property value="route.anchor_count"/> </li>
</ul>

</body>
</html>
