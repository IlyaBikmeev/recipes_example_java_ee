package com.example.demo.dao;

import com.example.demo.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecipeDaoImpl implements RecipeDao {

    private final List<Recipe> recipes;

    private static SimpleRecipeDaoImpl instance;

    private SimpleRecipeDaoImpl() {
        this.recipes = new ArrayList<>(List.of(
            Recipe.builder()
                .id(1)
                .author("i@ibikmeev.ru")
                .title("Драники")
                .description("Чтобы приготовить драники вам нужно....")
            .build(),

            Recipe.builder()
                .id(2)
                .author("i@ibikmeev.ru")
                .title("Пельмени")
                .description("Просто берёшь и варишь, справится даже безрукий...")
            .build()
        ));
    }

    public static SimpleRecipeDaoImpl getInstance() {
        if(instance == null) {
            instance = new SimpleRecipeDaoImpl();
        }
        return instance;
    }

    @Override
    public void save(Recipe recipe) {

        recipe.setId(recipes.size() + 1);
        recipes.add(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipes;
    }

    @Override
    public Recipe get(int id) {
        return recipes.stream()
                .filter(r -> r.getId() == id)
                .findAny().orElseThrow();
    }

    @Override
    public void delete(int id) {
        recipes.removeIf(r -> r.getId() == id);
    }

    @Override
    public void update(int id, Recipe recipe) {
        Recipe recipeToUpdate = get(id);

        recipeToUpdate.setAuthor(recipe.getAuthor());
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setTitle(recipe.getTitle());

    }
}
