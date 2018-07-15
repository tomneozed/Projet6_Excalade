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
<div class="container">
    <section> <%-- Description section --%>
        <s:actionmessage/>

        <h2 class="col-lg-offset-3"><s:text name="title.site.detail"/></h2>
        <div class="row">
            <div class="espace"></div>
        </div>
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
            <div class="warning">
                <s:text name="error.reservation.missing.log"></s:text>
            </div>
        </s:else>
        <div class="row">
            <div class="espace"></div>
        </div>
        <div class="row">
            <section class="col-lg-4 table-responsive">
                <table class="table table-bordered table-striped table-condensed">
                    <tbody>
                    <tr>
                        <td><s:text name="site.id"/></td>
                        <td><s:property value="site.id"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.name"/></td>
                        <td><s:property value="site.name"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.owner.id"/></td>
                        <td><s:property value="site.ownerId"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.state"/></td>
                        <td><s:property value="site.state"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.region"/></td>
                        <td><s:property value="site.region"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.county"/></td>
                        <td><s:property value="site.county"/></td>
                    </tr>
                    <tr>
                        <td><s:text name="site.add.day"/></td>
                        <td><s:property value="site.addDay"/></td>
                    </tr>
                    </tbody>
                </table>
            </section>
            <section class="col-lg-offset-1 col-lg-4"> <%-- Area list section --%>
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
        </div>
    </section>

    <section>

    </section>
</div>

</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
