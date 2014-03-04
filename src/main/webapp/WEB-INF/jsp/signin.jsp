<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="login">
    <h2>Please Sign In</h2>
    <form action="#" class="form-login">
        <div class="login-username">
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="login-password">
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </div>
        <div class="login-rememberme">
            <input type="checkbox" id="rememberme" name="rememberme" value="rememberme"/>
            <label for="rememberme">Remember me</label>
        </div>
        <div class="login-signin-forgot">
            <button type="submit">Sig In!</button>
            <a href="#">Forgot</a>
        </div>
    </form>
    <div class="new-account">
        <h3>Want an account?</h3>
        <p>
            <a href="#">Join for Free!</a>
        </p>
        <p>It's fast an easy!</p>
    </div>
</div>