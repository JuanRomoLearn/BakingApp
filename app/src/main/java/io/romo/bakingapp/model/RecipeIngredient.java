package io.romo.bakingapp.model;

public class RecipeIngredient {

    private String ingredient;
    private String measure;
    private int quantity;

    public RecipeIngredient() {

    }

    public RecipeIngredient(String ingredient, String measure, int quantity) {
        this.ingredient = ingredient;
        this.measure = measure;
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
