<%--
  Created by IntelliJ IDEA.
  User: neonzed
  Date: 23/05/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title><s:text name="title.comment.list" /></title>
    <%@ include file="../_include/header.jsp"%>
</head>
<body>
    <h2><s:text name="title.comment.list" /></h2>

    <ul>
        <s:iterator value="commentList">
            <li>
                <s:a action="comment_detail">
                    <s:param name="commentId" value="id" />
                    <s:property value="id"/>
                </s:a>
            </li>
        </s:iterator>
    </ul>

</body>
<footer>
    <%@ include file="../_include/footer.jsp"%>
</footer>
</html>
