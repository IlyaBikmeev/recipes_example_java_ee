package com.example.demo.dao;

import com.example.demo.model.Recipe;

import java.util.List;

public interface RecipeDao {
    void save(Recipe recipe);
    List<Recipe> getAll();
    Recipe get(int id);

    void delete(int id);

    void update(int id, Recipe recipe);
}
