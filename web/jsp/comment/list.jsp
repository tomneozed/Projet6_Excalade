<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 23/05/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title><s:text name="title.comment.list"/></title>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>
<header class="page-header">
    <%@ include file="../_include/header.jsp" %>
</header>
<div class="container">
    <h2><s:text name="title.comment.list"/></h2>

    <section>
        <s:if test="commentList.size() == 0">
            <s:text name="error.area.empty.route.list"/>
        </s:if>
        <s:else>
            <table class="table table-bordered table-striped table-condensed">
                <tr>
                    <th><s:text name="object.name"/></th>
                    <th><s:text name="comment.text"/></th>
                    <th><s:text name="title.delete"/></th>
                </tr>
                <s:iterator value="commentList">
                    <tr>
                        <td><s:property value="owner.surname"/> <s:property value="owner.firstName"/></td>
                        <td><s:property value="text"/></td>
                        <td>
                            <s:if test="#session.user.id == owner.id">
                                <s:a action="comment_delete">
                                    <s:param name="commentId" value="id"/>
                                    <s:text name="title.delete"/>
                                    <s:param name="areaId" value="areaId"/>
                                </s:a>
                            </s:if>
                            <s:else>
                                <s:text name="error.route.missing.log"/>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:else>
    </section>
</div>


</body>
<footer>
    <%@ include file="../_include/footer.jsp" %>
</footer>
</html>
