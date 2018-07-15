<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
    <title><s:text name="title.log"/></title>
    <%@ include file="./_include/bootstrap.jsp" %>
</head>

<body>
<header class="page-header">
    <%@ include file="./_include/header.jsp" %>
</header>

<div class="container">
    <h2 class="text-center"><s:text name="title.log"/></h2>

    <div class="row">
        <div class="col-sm-offset-4 col-sm-2 login-form">
            <s:form action="login">
                <div class="row">
                    <div class="col-lg-8">
                        <s:textfield name="login" label="Adresse Email" requiredLabel="true"/>
                        <s:password name="password" label="Mot de passe" requiredLabel="true"/>
                    </div>
                    <div class="col-lg-4">
                        <s:submit value="Connexion"/>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
    <div class="row">
        <s:if test="hasActionErrors()">
            <div class="col-lg-12">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </div>
        </s:if>
    </div>
</div>
<div class="row">
    <div class="espace"></div>
</div>

</body>
<footer>
    <%@ include file="./_include/footer.jsp" %>
</footer>
</html>
