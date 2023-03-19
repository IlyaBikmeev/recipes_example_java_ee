package com.example.demo.controller;

import com.example.demo.dao.RecipeDao;
import com.example.demo.dao.SimpleRecipeDaoImpl;
import com.example.demo.model.Recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateBookController", value = "/recipes/update")
public class UpdateRecipeController extends HttpServlet {

    private final RecipeDao dao = SimpleRecipeDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update_recipe.jsp");
        req.setAttribute("recipe", dao.get(id));
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        //DTO - data transfer object
        Recipe recipe = Recipe.builder()
            .title(req.getParameter("title"))
            .author(req.getParameter("author"))
            .description(req.getParameter("description"))
        .build();

        dao.update(id, recipe);
        resp.sendRedirect("/recipes");
    }
}
