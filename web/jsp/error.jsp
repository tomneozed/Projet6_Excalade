<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 23/05/18
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="./_include/header.jsp"%>
</head>
<body>

    <h2>Une erreur s'est produite</h2>

    <s:actionerror />

</body>
<footer>
    <%@ include file="./_include/footer.jsp"%>
</footer>
</html>
