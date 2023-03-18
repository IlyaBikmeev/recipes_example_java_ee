<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.03.2023
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Show recipe</h1>

    <div class="container">
        <h2>
            Рецепт:
            <c:out value="${requestScope.recipe.title}"/>
        </h2>
        <h3>
            Автор:
            <c:out value="${requestScope.recipe.author}" />
        </h3>

        <div class="description">
            <c:out value="${requestScope.recipe.description}" />
        </div>

        <div>
            <a href="/recipes">Назад к рецептам</a>

        </div>

        <form method="post" action="<c:out value="${'/recipes/delete?id='.concat(requestScope.recipe.id)}" />">
            <input type="submit" value="Удалить рецепт">
        </form>

        <div>
            <a href="<c:out value="${'recipes/update?id='.concat(requestScope.recipe.id)}"/>">Изменить рецепт</a>

        </div>
    </div>

</body>
</html>
