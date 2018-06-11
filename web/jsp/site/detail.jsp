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

    <s:actionmessage />

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

    <div>
        <strong>Liste des secteurs :</strong>
            <s:if test="site.areaList.size() == 0">
                Pas de secteurs rattachés à ce site
            </s:if>
            <s:else>
                <ul>
                    <s:iterator value="site.areaList">
                        <li>
                            <s:a action="area_detail">
                                <s:param name="areaId" value="id" />
                                <s:property value="name"/>
                            </s:a>
                        </li>
                    </s:iterator>
                </ul>
            </s:else>

        <s:a action="area_new">Ajouter un secteur</s:a>
    </div>
</body>
</html>
