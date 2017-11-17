package io.romo.bakingapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.romo.bakingapp.R;
import io.romo.bakingapp.fragment.RecipesFragment;
import io.romo.bakingapp.util.ActivityUtils;

public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipesFragment recipesFragment =
                (RecipesFragment) getSupportFragmentManager().findFragmentById(R.id.recipes_container);
        if (recipesFragment == null) {
            recipesFragment = new RecipesFragment();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), recipesFragment, R.id.recipes_container);
        }
    }
}
