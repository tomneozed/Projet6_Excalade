<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 22/05/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>titre</title>
</head>
<body>
    <h1><s:text name="home.welcome" /> </h1>
    <p>
        <s:a action="site_list">Liste des sites</s:a>
    </p>
    <p>
        <s:a action="area_list">Liste des secteurs</s:a>
    </p>
    <p>
        <s:a action="area_new">Ajouter un secteur</s:a>
    </p>
    <p>
        <s:a action="site_new">Ajouter un site</s:a>
    </p>
    <p>
        <s:a action="route_new">Ajouter une voie</s:a>
    </p>

</body>
</html>
