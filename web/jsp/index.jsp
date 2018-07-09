<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 22/05/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Excalade</title>
</head>
<body>
<header class="page-header">
    <%@ include file="./_include/header.jsp" %>
</header>
<div class="container">

    <div class="row">
        <h1><s:text name="home.welcome"/></h1>
    </div>

    <div class="row">
        <s:include value="research/form.jsp"></s:include>
    </div>

    <div>
        <p>
            <s:a action="site_list">
                <s:text name="title.site.list"/>
            </s:a>
        </p>
    </div>

    <div class="row">
        <p>
            <s:a action="area_list">
                <s:text name="title.area.list"/>
            </s:a>
        </p>
    </div>

    <div class="row">
        <p>
            <s:a action="area_new">
                <s:text name="title.area.new"/>
            </s:a>
        </p>
    </div>

    <div class="row">
        <p>
            <s:a action="site_new">
                <s:text name="title.site.new"/>
            </s:a>
        </p>
    </div>

    <div class="row">
        <p>
            <s:a action="route_new">
                <s:text name="title.route.new"/>
            </s:a>
        </p>
    </div>

    <div class="row">
        <div class="col-lg12">
            <s:a action="comment_list">
                <s:text name="title.comment.list"/>
            </s:a>
        </div>
    </div>

</div>

</body>

<footer>
    <%@ include file="./_include/footer.jsp" %>
</footer>
</html>
