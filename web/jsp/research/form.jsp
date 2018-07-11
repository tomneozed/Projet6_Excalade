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
<head>
    <%@ include file="../_include/bootstrap.jsp" %>
</head>
<body>

<style type="text/css">
    .errors {
        background-color: #FFCCCC;
        border: 1px solid #CC0000;
        width: 400px;
        margin-bottom: 8px;
    }
</style>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>


<s:form action="research">
    <div class="row">
        <s:textfield name="researchInput" key="title.site.research" requiredLabel="true"/>
        <s:submit key="title.research"><span class="glyphicon glyphicon-eye-open"></span> </s:submit>
    </div>
</s:form>


</body>
</html>
