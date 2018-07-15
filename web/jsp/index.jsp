<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 22/05/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>Excalade</title>
    <%@ include file="./_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header text-center">
    <%@ include file="./_include/header.jsp" %>
    
</header>
<div class="container">

    <div class="row text-center">
        <h1><s:text name="home.welcome"/></h1>
    </div>

    <div class="row">
        <div class="align-center">
            <s:include value="research/form.jsp"> </s:include>
        </div>
    </div>
</div>
</body>

<footer class="text-center">
    <s:a name="index">
        <s:param name="request_locale">en</s:param>
        [English]
    </s:a>
    <s:a name="index">
        <s:param name="request_locale">fr</s:param>
        [Français]
    </s:a>
    <%@ include file="./_include/footer.jsp" %>
</footer>
</html>
