package com.example.demo.controller;

import com.example.demo.dao.RecipeDao;
import com.example.demo.dao.SimpleRecipeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteBookController", value = "/recipes/delete")
public class DeleteRecipeController extends HttpServlet {

    private final RecipeDao dao = SimpleRecipeDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect("/recipes");
    }
}
