<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 03/07/2018
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<section>
    <s:if test="routeList.size() == 0">
        <s:text name="error.area.empty.route.list" />
    </s:if>
    <s:else>
        <table>
            <tr>
                <th><s:text name="route.id" /></th>
                <th><s:text name="route.area.id" /></th>
                <th><s:text name="route.number" /></th>
                <th><s:text name="route.height" /></th>
                <th><s:text name="route.grade" /></th>
                <th><s:text name="route.anchor.count" /></th>
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
                    <td><s:a action="route_delete" >
                        <s:param name="routeId" value="id" />
                        <s:text name="title.delete"></s:text>
                    </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:else>
</section>

</body>
</html>
