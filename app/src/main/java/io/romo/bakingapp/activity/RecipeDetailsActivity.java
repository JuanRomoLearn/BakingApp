package io.romo.bakingapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.romo.bakingapp.R;
import io.romo.bakingapp.fragment.RecipeIngredientsFragment;
import io.romo.bakingapp.model.Recipe;
import io.romo.bakingapp.util.ActivityUtils;

public class RecipeDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_RECIPE = "io.romo.bakingapp.recipe";

    private Recipe recipe;

    public static Intent newIntent(Context packageContext, Recipe recipe) {
        Intent intent = new Intent(packageContext, RecipeDetailsActivity.class);
        intent.putExtra(EXTRA_RECIPE, recipe);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        recipe = getIntent().getParcelableExtra(EXTRA_RECIPE);

        RecipeIngredientsFragment recipeIngredientsFragment =
                (RecipeIngredientsFragment) getSupportFragmentManager().findFragmentById(R.id.recipe_ingredients_container);
        if (recipeIngredientsFragment == null) {
            recipeIngredientsFragment = RecipeIngredientsFragment.newInstance(recipe);
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), recipeIngredientsFragment, R.id.recipe_ingredients_container);
        }
    }
}
