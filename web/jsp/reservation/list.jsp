<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 27/06/2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
    <h2><s:text name="title.reservation.list" /></h2>

    <section>
        <s:if test="reservationList.size() == 0">
            <s:text name="error.reservation.empty.list" />
        </s:if>
        <s:else>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Site ID</th>
                    <th>Date de reservation (debut)</th>
                    <th>Date de reservation (fin)</th>
                    <th>Supprimer</th>
                </tr>
                    <s:iterator value="reservationList">
                        <tr>
                            <td><s:property value="id" /></td>
                            <td><s:property value="site_id" /></td>
                            <td><s:property value="reservation_day_start"/></td>
                            <td><s:property value="reservation_day_end"/></td>
                            <td><s:a action="reservation_delete" >
                                <s:param name="reservationId" value="id" />
                                <s:text name="title.delete"></s:text>
                            </s:a>
                            </td>
                        </tr>
                    </s:iterator>
            </table>
        </s:else>
    </section>

</body>
<footer>
    <%@ include file="../_include/footer.jsp"%>
</footer>
</html>
