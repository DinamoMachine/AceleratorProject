<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/styleLogin.css" />
</head>
<body>
    <div class="wrapper">
        <div class="loginContainer">
            <h1>Авторизация</h1>

            <#-- Если в URL есть параметр error, выводим сообщение об ошибке -->
            <#if error??>
                <p style="color: red;">Неверное имя пользователя или пароль. Попробуйте снова.</p>
            </#if>

            <form action="/login" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                <br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <br>
                <button type="submit">Авторизоваться</button>
            </form>

            <p><a href="/register">Зарегистрироваться</a></p>
        </div>
    </div>
</body>
</html>
