<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.03.2023
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create recipe</title>
</head>
<body>

    <form method="post" action="/recipes">
        <div>
            <label for="author">Автор рецепта</label>
            <input type="text" id="author" name="author">
        </div>
        <div>
            <label for="title">Название рецепта</label>
            <input type="text" id="title" name="title">
        </div>
        <div>
            <label for="description">Описание</label>
            <textarea name="description" id="description" cols="70" rows="20" style="resize: none;"></textarea>
        </div>

        <div>
            <input type="submit" value="Создать рецепт">
        </div>

    </form>

</body>
</html>
