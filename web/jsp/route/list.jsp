<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 04/06/18
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="title.route.list"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>

<div class="container">
    <h2><s:text name="title.route.list"/></h2>

    <section>
        <s:if test="routeList.size() == 0">
            <s:text name="error.area.empty.route.list"/>
        </s:if>
        <s:else>
            <table class="table table-bordered table-striped table-condensed">
                <tr>
                    <th><s:text name="route.id"/></th>
                    <th><s:text name="route.area.id"/></th>
                    <th><s:text name="route.number"/></th>
                    <th><s:text name="route.height"/></th>
                    <th><s:text name="route.grade"/></th>
                    <th><s:text name="route.anchor.count"/></th>
                    <th><s:text name="title.delete"/></th>
                </tr>
                <s:iterator value="routeList">
                    <tr>
                        <td><s:property value="id"/></td>
                        <td><s:property value="areaId"/></td>
                        <td><s:property value="routeNumber"/></td>
                        <td><s:property value="height"/></td>
                        <td><s:property value="grade"/></td>
                        <td><s:property value="anchorCount"/></td>
                        <td>
                            <s:if test="#session.user.id == ownerId">
                                <s:a action="route_delete">
                                    <s:param name="routeId" value="id"/>
                                    <s:text name="title.delete"/>
                                    <s:param name="areaId" value="areaId"/>
                                </s:a>
                            </s:if>
                            <s:else>
                                <s:text name="error.route.missing.log"/>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:else>
    </section>
</div>


</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
