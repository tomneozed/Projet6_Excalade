<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 09/07/2018
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>

<s:form action="research">
    <s:textfield name="researchInput" key="title.site.research" requiredLabel="true"/>
    <s:submit key="title.research"></s:submit>
</s:form>


</body>
</html>
