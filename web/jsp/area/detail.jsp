<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 05/06/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title><s:text name="title.area.detail" /></title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
<h2><s:text name="title.area.detail" /></h2>
    <section> <%-- Details section --%>
        <ul>
            <li><s:text name="area.id" /> : <s:property value="area.id" /> </li>
            <li><s:text name="area.name" /> : <s:property value="area.name"/> </li>
            <li><s:text name="area.route.count" /> : <s:property value="area.routeCount"/> </li>
            <li><s:text name="area.type" /> : <s:property value="area.type"/> </li>
            <li><s:text name="area.description" /> : <s:property value="area.description"/> </li>
        </ul>
    </section>

    <section> <%-- Route list section --%>
        <p>
            <strong><s:text name="title.route.list" /></strong>

            <s:a action="route_new">
                <s:text name="title.route.new" />
                <s:param name="areaId" value="%{area.id}" />
            </s:a>
        </p>
        <div>
            <s:if test="area.routeList.size() == 0">
                <s:text name="error.area.empty.route.list" />
            </s:if>
            <s:else>
                <ul>
                    <s:iterator value="area.routeList">
                        <li>
                            <s:a action="route_detail">
                                <s:param name="routeId" value="id" />
                                <s:property value="routeNumber"/>
                            </s:a>
                        </li>
                    </s:iterator>
                </ul>
            </s:else>
        </div>
    </section>
    <section> <%-- Comments section --%>

    </section>
</body>
</html>
