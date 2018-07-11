<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 09/07/2018
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Research List</title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <h2><s:text name="title.site.list"/></h2>
    <div class="row">
        <s:include value="../research/form.jsp"></s:include>
    </div>

    <s:if test="siteList.size() == 0">
        <s:text name="error.research.list.empty"/>
    </s:if>
    <s:else>
        <ul>
            <s:iterator value="siteList">
                <li>
                    <s:a action="site_detail">
                        <s:param name="siteId" value="id"/>
                        <s:property value="name"/>
                    </s:a>
                </li>
            </s:iterator>
        </ul>
    </s:else>
</div>
</body>
</html>
