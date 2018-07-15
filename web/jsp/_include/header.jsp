<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>

</head>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header navbar-brand">
            <s:text name="title.excalade"></s:text>
        </div>
        <ul class="nav navbar-nav">
            <li><s:a action="index">
                <s:text name="home.nav"/>
            </s:a>
            </li>

            <li><s:a action="site_list">
                <s:text name="title.site.list"/>
            </s:a>
            </li>
            <s:if test="#session.user">
                <li><s:a action="site_new">
                    <s:text name="title.site.new"/>
                </s:a>
                </li>
                <li>
                    <s:a action="reservation_list">
                        <s:text name="title.reservation.list"></s:text>
                    </s:a>
                </li>
            </s:if>
            <s:if test="#session.user">
                <li class="navbar-brand">
                    <s:property value="#session.user.firstName"/>
                    <s:property value="#session.user.surname"/>
                </li>
                <li>
                    <s:a action="logout">
                        <s:text name="connexion.logout"/>
                    </s:a>
                </li>
            </s:if>
            <s:else>
                <li>
                    <s:a action="login">
                        <s:text name="connexion.login"/>
                    </s:a>
                </li>
            </s:else>
        </ul>
    </div>
</nav>