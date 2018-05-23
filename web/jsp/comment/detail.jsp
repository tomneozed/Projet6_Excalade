<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 23/05/18
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Detail du commentaire</h2>

    <ul>
        <li>ID : <s:property value="id"/> </li>
        <li>Texte : <s:property value="comment.text"/> </li>
        <li>Utilisateur ID : <s:property value="comment.user_id"/> </li>
        <li>Secteur ID : <s:property value="comment.area_id"/> </li>
    </ul>

</body>
</html>
