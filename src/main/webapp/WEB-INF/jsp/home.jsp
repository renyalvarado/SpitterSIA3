<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
    <h2>
        A global community of friends and strangers spitting out their
        inner-most and personal thoughts on the web for everyone else to
        see.
    </h2>
    <h3>Look at what these people are spitting right now...</h3>
    <div class='spittleList'>
        <c:forEach var="spittle" items="${spittles}">
            <s:url value="/spitters/{spitterName}" var="spitterUrl" >
                <s:param name="spitterName" value="${spittle.spitter.username}"/>
            </s:url>
            <div class="spittleItem">
                <span class="spittleSpitterImage">
                    <img src="<c:url value='/static/img/${spittle.spitter.username}_48x48.png'/>"/>
                </span>
                <span class="spittleSpitter">
                    <a href="${spitterUrl}">${spittle.spitter.username}</a>
                </span>
                <span class="spittleWhen">
                    <fmt:formatDate type="both" value="${spittle.when}"/>
                </span>
                <span class="spittleListText">${spittle.text}</span>
            </div>
        </c:forEach>
    </div>
</div>
