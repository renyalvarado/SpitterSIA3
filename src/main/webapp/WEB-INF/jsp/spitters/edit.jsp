<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="spitter-info">
    <h2>Create a free Spitter account</h2>
    <sf:form method="post"  modelAttribute="spitter">
        <fieldset>
            <div class="spitter-info-element">
                <span class="spitter-info-title">
                    <label for="user_screen_name">Username:</label>
                </span>
                <span class="spitter-info-input-section">
                    <sf:input path="username" size="15" cssErrorClass="input-error"
                              maxlength="15" id="user_screen_name"/>
                    <span class="spitter-info-comment">
                        No spaces, please.
                    </span>
                    <sf:errors path="username" cssClass="error"/>
                </span>
            </div>
            <div class="spitter-info-element">
                <span class="spitter-info-title">
                    <label for="user_full_name">Full name:</label>
                </span>
                <span class="spitter-info-input-section">
                    <sf:input path="fullname" size="30" cssErrorClass="input-error"
                              maxlength="100" id="user_full_name"/>
                    <sf:errors path="fullname" cssClass="error"/>
                </span>
            </div>
            <div class="spitter-info-element">
                <span class="spitter-info-title">
                    <label for="user_password">Password:</label>
                </span>
                <span class="spitter-info-input-section">
                    <sf:password path="password" size="30" maxlength="50" cssErrorClass="input-error"
                                 showPassword="true" id="user_password"/>
                    <span class="spitter-info-comment">
                        6 characters or more (be tricky!)
                    </span>
                    <sf:errors path="password" cssClass="error"/>
                </span>
            </div>
            <div class="spitter-info-element">
                <span class="spitter-info-title">
                    <label for="user_email">Email:</label>
                </span>
                <span class="spitter-info-input-section">
                    <sf:input path="email" size="30" maxlength="100" id="user_email" cssErrorClass="input-error"/>
                    <span class="spitter-info-comment">
                        In case you forget something
                    </span>
                    <sf:errors path="email" cssClass="error"/>
                </span>
            </div>
            <div class="spitter-info-element">
                <span class="spitter-info-title"></span>
                <span class="spitter-info-input-section">
                    <sf:checkbox path="updatebyemail" id="user_updatebyemail"/>
                    <label for="user_updatebyemail">Send me email for updates!</label>
                </span>
            </div>
            <div class="spitter-info-element">
                <span class="spitter-info-title"></span>
                <span class="spitter-info-input-section">
                    <input name="commit" type="submit" value="I accept. Create my Account"/>
                </span>
            </div>
        </fieldset>
    </sf:form>
</div>