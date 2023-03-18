<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.03.2023
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form method="post" action="<c:out value="${'/recipes/update?id='.concat(requestScope.recipe.id)}" />">
        <div>
            <label for="author">Автор рецепта</label>
            <input type="text" id="author" name="author" value="${requestScope.recipe.author}">
        </div>
        <div>
            <label for="title">Название рецепта</label>
            <input type="text" id="title" name="title" value="${requestScope.recipe.title}">
        </div>
        <div>
            <label for="description">Описание</label>
            <textarea name="description" id="description"
                      cols="70" rows="20"
                      style="resize: none;">
                <c:out value="${requestScope.recipe.description}"/>
            </textarea>
        </div>

        <div>
            <input type="submit" value="Изменить рецепт">
        </div>
    </form>

    <div>
        <a href="<c:out value="${'/recipes?id='.concat(requestScope.recipe.id)}"/>">Назад к рецепту</a>
    </div>

</body>
</html>
