package com.example.demo.controller;

import com.example.demo.dao.RecipeDao;
import com.example.demo.dao.SimpleRecipeDaoImpl;
import com.example.demo.model.Recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "allBooksController", value="/recipes")
public class AllBooksController extends HttpServlet {

    private final RecipeDao dao = SimpleRecipeDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ServletContext servlet = getServletContext();

        if(id != null) {
            req.setAttribute("recipe", dao.get(Integer.parseInt(id)));
            servlet.getRequestDispatcher("/show_recipe.jsp").forward(req, resp);
            return;
        }

        RequestDispatcher requestDispatcher = servlet.getRequestDispatcher("/all_recipes.jsp");

        req.setAttribute("recipes", dao.getAll());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Recipe recipe = Recipe.builder()
            .author(req.getParameter("author"))
            .title(req.getParameter("title"))
            .description(req.getParameter("description"))
        .build();
        dao.save(recipe);
        System.out.println(recipe);
        resp.sendRedirect("/recipes");
    }
}
