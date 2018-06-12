<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 05/06/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Detail du secteur</h2>
<ul>
    <li>ID : <s:property value="area.id"/> </li>
    <li>Nom : <s:property value="area.name"/> </li>
    <li>Nombre de voies : <s:property value="area.route_count"/> </li>
    <li>Type : <s:property value="area.type"/> </li>
    <li>Description : <s:property value="area.description"/> </li>
</ul>

<div>
    <strong>Liste des voies :</strong>
    <s:if test="area.routeList.size() == 0">
        Pas de voies rattachées à ce site
    </s:if>
    <s:else>
        <ul>
            <s:iterator value="area.routeList">
                <li>
                    <s:a action="route_detail">
                        <s:param name="routeId" value="id" />
                        <s:property value="id"/>
                    </s:a>
                </li>
            </s:iterator>
        </ul>
    </s:else>

    <p>
        <s:a action="route_new">Ajouter une voie
            <s:param name="areaId" value="%{area.id}" />
        </s:a>
    </p>
</div>
</body>
</html>
