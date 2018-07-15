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
    <link href="style.css" rel="stylesheet" type="text/css" media="all">

</head>
<body>


<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-offset-3 col-lg-5 research">
            <s:form action="research">
                <s:textfield class="" name="researchInput" key="title.site.research" requiredLabel="true"/>
                <s:submit key="title.research"></s:submit>
            </s:form>
        </div>
        <s:if test="hasActionErrors()">
            <div class="col-lg-2">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </div>
        </s:if>
    </div>

</div>


</body>
</html>
