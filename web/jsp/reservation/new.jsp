<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix = "sx" uri = "/struts-dojo-tags"%>
<html>
<head>
    <sx:head />
    <title>Title</title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
    <h2><s:text name="title.reservation.new" /></h2>

    <s:form action="reservation_new">
        <sx:datetimepicker name="reservation.reservation_day_start" key="reservation.day.start" displayFormat="dd-MM-yyyy" value="" requiredLabel="true"/>
        <sx:datetimepicker name="reservation.reservation_day_end" key="reservation.day.end" displayFormat="dd-MM-yyyy" value="" requiredLabel="true"/>
        <s:hidden name="siteId" />
        <s:hidden name="reservation.id" />
        <s:submit value="OK"/>
    </s:form>

</body>
<footer>
    <%@ include file="../_include/footer.jsp"%>
</footer>
</html>
