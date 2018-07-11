<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 26/05/18
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="title.site.detail"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<section> <%-- Description section --%>
    <s:actionmessage/>

    <h2><s:text name="title.site.detail"/></h2>
    <%-- Delete option --%>
    <s:if test="#session.user.id == site.ownerId">
        <s:a action="site_delete">
            <s:param name="siteId" value="%{site.id}"/>
            <s:text name="title.delete"/>
        </s:a>
    </s:if>

    <%-- Reservation option --%>
    <s:if test="#session.user">
        <s:if test="#session.user.id != site.ownerId">
            <s:a action="reservation_new">
                <s:param name="siteId" value="%{site.id}"/>
                <s:text name="title.reservation"/>
            </s:a>
        </s:if>
    </s:if>
    <s:else>
        <s:text name="error.reservation.missing.log"></s:text>
    </s:else>


    <ul>
        <li><s:text name="site.id"/> : <s:property value="site.id"/></li>
        <li><s:text name="site.name"/> : <s:property value="site.name"/></li>
        <li><s:text name="site.owner.id"/> : <s:property value="site.ownerId"/></li>
        <li><s:text name="site.state"/> : <s:property value="site.state"/></li>
        <li><s:text name="site.region"/> : <s:property value="site.region"/></li>
        <li><s:text name="site.county"/> : <s:property value="site.county"/></li>
        <li><s:text name="site.add.day"/> : <s:property value="site.addDay"/></li>
    </ul>
</section>

<section> <%-- Area list section --%>
    <strong><s:text name="title.area.list"/></strong>

    <%-- add Area option --%>
    <p>
        <s:if test="#session.user.id == site.ownerId">
            <s:a action="area_new">
                <s:text name="title.area.new"/>
                <s:param name="siteId" value="%{site.id}"/>
            </s:a>
        </s:if>
    </p>

    <div>
        <s:if test="site.areaList.size() == 0">
            <s:text name="error.site.empty.area.list"/>
        </s:if>
        <s:else>
            <ul>
                <s:iterator value="site.areaList">
                    <li>
                        <p>
                            <s:a action="area_detail">
                                <s:param name="areaId" value="id"/>
                                <s:param name="siteId" value="%{site.id}"/>
                                <s:property value="name"/>
                            </s:a>
                        </p>
                        <p>
                            <s:text name="area.route.count"/>
                            :
                            <s:property value="routeCount"/>
                        </p>
                    </li>
                </s:iterator>
            </ul>
        </s:else>
    </div>
</section>
</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
