<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>

<ul>
    <li><s:text name="reservation.id"/> : <s:property value="reservation.id"/></li>
    <li><s:text name="reservation.site.id"/> : <s:property value="reservation.site_id"/></li>
    <li><s:text name="reservation.tenant.id"/> : <s:property value="reservation.tenant_id"/></li>
    <li><s:text name="reservation.day.start"/> : <s:property value="reservation.reservation_day_start"/></li>
    <li><s:text name="reservation.day.end"/> : <s:property value="reservation.reservation_day_end"/></li>
</ul>

</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
