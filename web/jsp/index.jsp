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
    <h1>Bienvenue !</h1>

    <s:a action="comment_list">Liste des commentaires</s:a>
    <s:a action="site_list">Liste des sites</s:a>
</body>
</html>
