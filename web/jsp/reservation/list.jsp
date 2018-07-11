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
    <title><s:text name="title.reservation.list"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>

</head>
<body>
<header>
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <s:if test="reservationList.size() == 0">
        <s:text name="error.reservation.empty.list"/>
    </s:if>
    <s:else>
        <table class="table table-bordered table-striped table-condensed">
            <caption>
                <h4><s:text name="title.reservation.list"/></h4>
            </caption>
            <thead>
            <tr>
                <th><s:text name="reservation.id"/></th>
                <th><s:text name="reservation.site.id"/></th>
                <th><s:text name="reservation.day.start"/></th>
                <th><s:text name="reservation.day.end"/></th>
                <th><s:text name="title.delete"/></th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="reservationList">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="site_id"/></td>
                    <td><s:property value="reservation_day_start"/></td>
                    <td><s:property value="reservation_day_end"/></td>
                    <td><s:a action="reservation_delete">
                        <s:param name="reservationId" value="id"/>
                        <s:text name="title.delete"></s:text>
                    </s:a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:else>
</div>

</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
