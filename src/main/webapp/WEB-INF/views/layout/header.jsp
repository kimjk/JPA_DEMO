<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<aticle class="header">
    <div class="home"><a href="<c:url value='/main'/>"><img src="<c:url value='/static/images/icon_home.png'/>"></a>
    </div>
    <h1><img src="<c:url value='/static/images/logo.png'/>"></h1>
    <div class="logout">
        <span>
            <%--<sec:authentication property="name"/>님--%>
        </span>
        <a href="<c:url value='/auth/logout'/>"><img src="<c:url value='/static/images/icon_logout.png'/>"></a>
    </div>
</aticle>