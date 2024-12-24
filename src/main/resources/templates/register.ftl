<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/css/styleRegister.css" />
</head>
<body>
    <div class="wrapper">
        <div class="registerContainer">
            <h1>Регистрация</h1>
            <form action="/register" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                <br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <br>
                <button type="submit">Зарегестрироваться</button>
            </form>
        </div>
    </div>

    <#-- Вывод сообщения об успешной регистрации, если оно присутствует -->
    <#if success??>
        <p style="color: green;">${success}</p>
    </#if>
</body>
</html>
