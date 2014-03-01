<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="login">
    <h2>Please Sign In</h2>
    <form action="#" class="form-login">
        <span class="login-username">
            <label for="usename">Username</label>
            <input type="text" id="username" name="name"/>
        </span>
        <span class="login-password">
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </span>
        <span class="login-rememberme">
            <input type="checkbox" name="rememberme" value="rememberme">Remember me<br>
        </span>
        <span class="login-signin-forgot">
            <button type="submit">Sig In!</button>
            <a href="#">Forgot</a>
        </span>
    </form>
    <div class="new-account">
        <h3>Want an account?</h3>
        <p>
            <a href="#">Join for Free!</a>
        </p>
        <p>It's fast an easy!</p>
    </div>
</div>

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
