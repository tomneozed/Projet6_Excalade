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
    <title><s:text name="title.comment.detail" /></title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
    <h2><s:text name="title.comment.detail" /></h2>

    <ul>
        <li><s:text name="comment.id" /> : <s:property value="comment.id"/> </li>
        <li><s:text name="comment.text" /> : <s:property value="comment.text"/> </li>
        <li><s:text name="comment.user.id" /> : <s:property value="comment.user_id"/> </li>
        <li><s:text name="comment.area.id" /> : <s:property value="comment.area_id"/> </li>
    </ul>

</body>
<footer>
    <%@ include file="../_include/footer.jsp"%>
</footer>
</html>
