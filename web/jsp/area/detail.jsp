<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 05/06/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><s:text name="title.area.detail"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<h2><s:text name="title.area.detail"/></h2>
<%-- Delete option --%>
<s:if test="#session.user.id == area.ownerId">
    <s:a action="area_delete">
        <s:param name="areaId" value="%{area.id}"/>
        <s:text name="title.delete"/>
    </s:a>
</s:if>
<section> <%-- Details section --%>
    <ul>
        <li><s:text name="area.id"/> : <s:property value="area.id"/></li>
        <li><s:text name="area.name"/> : <s:property value="area.name"/></li>
        <li><s:text name="area.route.count"/> : <s:property value="area.routeCount"/></li>
        <li><s:text name="area.type"/> : <s:property value="area.type"/></li>
        <li><s:text name="area.description"/> : <s:property value="area.description"/></li>
    </ul>
</section>

<section> <%-- Route list section --%>
    <p>
        <strong><s:text name="title.route.list"/></strong>

        <s:if test="#session.user.id == area.ownerId">
            <s:a action="route_new">
                <s:text name="title.route.new"/>
                <s:param name="areaId" value="%{area.id}"/>
            </s:a>
        </s:if>
    </p>
    <div>
        <s:if test="area.routeList.size() == 0">
            <s:text name="error.area.empty.route.list"/>
        </s:if>
        <s:else>
            <s:a action="route_list">
                <s:param name="areaId" value="%{area.id}"/>
                <s:text name="title.route.list"/>
            </s:a>
        </s:else>
    </div>
</section>

<section> <%-- Comments section --%>
    <p>
        <s:if test="area.commentList.size() == 0">
            <s:text name="error.area.empty.comment.list"/>
        </s:if>
        <s:else>
            <s:a action="comment_list">
                <s:param name="areaId" value="%{area.id}"/>
                <s:text name="title.comment.list"/>
            </s:a>
        </s:else>
    </p>
    <p>
        <s:if test="#session.user">
            <s:a action="comment_new">
                <s:text name="title.comment.new"/>
                <s:param name="areaId" value="%{area.id}"/>
            </s:a>
        </s:if>
    </p>
</section>
</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
