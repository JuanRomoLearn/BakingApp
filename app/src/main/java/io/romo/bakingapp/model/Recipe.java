package io.romo.bakingapp.model;

import java.util.List;

public class Recipe {

    private int id;
    private String name;
    private int servings;
    private String image;
    private List<RecipeIngredient> recipeIngredients;
    private List<RecipeStep> recipeSteps;

    public Recipe() {

    }

    public Recipe(int id, String name, int servings, String image,
                  List<RecipeIngredient> recipeIngredients, List<RecipeStep> recipeSteps) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;
        this.recipeIngredients = recipeIngredients;
        this.recipeSteps = recipeSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
