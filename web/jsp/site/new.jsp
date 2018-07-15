<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 10/06/18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.site.new"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <s:actionerror/>
    <s:actionmessage/>

    <s:if test="#session.user">

        <h2><s:text name="title.site.new"/></h2>

        <s:form action="site_new">
            <s:textfield name="site.state" key="site.state" requiredLabel="true"/>
            <s:textfield name="site.region" key="site.region" requiredLabel="true"/>
            <s:textfield name="site.county" key="site.county" requiredLabel="false"/>
            <s:textfield name="site.name" key="site.name" requiredLabel="true"/>
            <s:hidden name="siteId"/>
            <s:submit value="OK"/>
        </s:form>
    </s:if>
    <s:else>
        <s:text name="error.not.logged"/>
    </s:else>
</div>

</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
