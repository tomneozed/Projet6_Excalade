<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="title.reservation.new"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <h2><s:text name="title.reservation.new"/></h2>
    <div class="row">
        <div class="col-lg-5">
            <s:form action="reservation_new">
                <s:textfield name="reservation.reservation_day_start" key="reservation.day.start" requiredLabel="true"/>
                <s:textfield name="reservation.reservation_day_end" key="reservation.day.end" requiredLabel="true"/>

                <s:hidden name="siteId"/>
                <s:hidden name="reservation.id"/>
                <s:submit value="OK"/>
            </s:form>
        </div>
        <div class="col-lg-4">
            <s:if test="hasActionErrors()">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </s:if>
        </div>
    </div>


</div>

</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
