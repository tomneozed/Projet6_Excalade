<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
    <title><s:text name="title.log"/></title>
    <%@ include file="./_include/header.jsp"%>
</head>

<body>

<h2><s:text name="title.log"/></h2>

<s:form action="login">
    <s:textfield name="login" label="Adresse Email" requiredLabel="true" />
    <s:password name="password" label="Mot de passe" requiredLabel="true" />

    <s:submit value="Connexion"/>
</s:form>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>
</body>
<footer>
    <%@ include file="./_include/footer.jsp"%>
</footer>
</html>
