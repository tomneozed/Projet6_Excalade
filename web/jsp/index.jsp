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
    <title>Excalade</title>
    <%@ include file="./_include/header.jsp"%>
</head>
<body>
    <h1><s:text name="home.welcome" /> </h1>
    <p>
        <s:a action="site_list" >
            <s:text name="title.site.list"/>
        </s:a>
    </p>
    <p>
        <s:a action="area_list">
            <s:text name="title.area.list"/>
        </s:a>
    </p>
    <p>
        <s:a action="area_new">
            <s:text name="title.area.new"/>
        </s:a>
    </p>
    <p>
        <s:a action="site_new">
            <s:text name="title.site.new"/>
        </s:a>
    </p>
    <p>
        <s:a action="route_new">
            <s:text name="title.route.new"/>
        </s:a>
    </p>

</body>

<footer>
    <%@ include file="./_include/footer.jsp"%>
</footer>
</html>
