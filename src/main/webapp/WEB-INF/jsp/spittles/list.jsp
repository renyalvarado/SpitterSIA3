<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
    <h2>Spittles for ${spitter.username}</h2>
    <div class='spittleList'>
        <c:forEach var="spittle" items="${spittleList}">
            <s:url value="/spitters/{spitterName}" var="spitterUrl" >
                <s:param name="spitterName" value="${spitter.username}"/>
            </s:url>
            <div class="spittleItem">
                <span class="spittleSpitterImage">
                    <img src="<c:url value='/static/img/${spitter.username}_48x48.png'/>" alt="${spitter.username}"/>
                </span>
                <span class="spittleSpitter">
                    <a href="${spitterUrl}">${spitter.username}</a>
                </span>
                <span class="spittleWhen">
                    <fmt:formatDate type="both" value="${spittle.when}"/>
                </span>
                <span class="spittleListText">${spittle.text}</span>
            </div>
        </c:forEach>
    </div>
</div>
