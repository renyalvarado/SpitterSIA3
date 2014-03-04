<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="spitter-info">
    <h2>Spitter Info</h2>
    <fieldset>
        <div class="spitter-info-element">
            <span class="spitter-info-title">
                Image:
            </span>
            <span class="spitter-info-value">
                <img src="<c:url value='/static/img/${spitter.username}_48x48.png'/>" alt="${spitter.username}"/>
            </span>
        </div>
        <div class="spitter-info-element">
            <span class="spitter-info-title">
                Full name:
            </span>
            <span class="spitter-info-value">
                ${spitter.fullname}
            </span>
        </div>
        <div class="spitter-info-element">
            <span class="spitter-info-title">
                Username:
            </span>
            <span class="spitter-info-value">
                ${spitter.username}
            </span>
        </div>
        <div class="spitter-info-element">
            <span class="spitter-info-title">
                Email Address:
            </span>
            <span class="spitter-info-value">
                ${spitter.email}
            </span>
        </div>
        <div class="spitter-info-element">
            <span class="spitter-info-title">
                Update by Email:
            </span>
            <span class="spitter-info-value">
                ${spitter.updatebyemail ? "Yes" : "No"}
            </span>
        </div>  
    </fieldset>
</div>