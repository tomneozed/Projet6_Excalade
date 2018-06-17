<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
    <s:if test="#session.user">
        <s:text name="connected.user"/>
        :
        <s:property value="#session.user.firstName" />
        <s:property value="#session.user.lastName" />

        <s:a action="logout">
            <s:text name="connexion.logout"/>
        </s:a>
    </s:if>
    <s:else>
        <s:a action="login">
            <s:text name="connexion.login"/>
        </s:a>
    </s:else>
</header>

<nav>
    <s:a action="site_list">
        <s:text name="title.site.list" />
    </s:a>

    <s:a action="site_new">
        <s:text name="title.site.new" />
    </s:a>
</nav>

<s:actionerror/>
<s:actionmessage/>