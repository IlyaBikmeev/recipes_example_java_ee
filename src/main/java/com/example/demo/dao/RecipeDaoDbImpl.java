package com.example.demo.dao;

import com.example.demo.model.Recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RecipeDaoDbImpl implements RecipeDao {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/recipes-top";
    private final String USER = "root";
    private final String PASSWORD = "123";

    private static RecipeDaoDbImpl instance;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static RecipeDaoDbImpl getInstance() {
        if(instance == null) {
            instance = new RecipeDaoDbImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    @Override
    public void save(Recipe recipe) {

    }

    @Override
    public List<Recipe> getAll() {
        return null;
    }

    @Override
    public Recipe get(int id) {
        String query = "SELECT * FROM recipe WHERE id = ?";

        try(Connection cnn = getConnection()) {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            ResultSet set = statement.getResultSet();
            set.next();

            return Recipe.builder()
                    .author(set.getString("author"))
                    .id(id)
                    .title(set.getString("title"))
                    .description(set.getString("description"))
                    .build();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Recipe recipe) {

    }
}
