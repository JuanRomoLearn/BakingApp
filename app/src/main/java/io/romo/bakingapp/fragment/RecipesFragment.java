package io.romo.bakingapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.romo.bakingapp.R;
import io.romo.bakingapp.adapter.RecipesAdapter;
import io.romo.bakingapp.model.Recipe;


public class RecipesFragment extends Fragment implements RecipesAdapter.RecipeItemListener {

    @BindView(R.id.recipes) RecyclerView recipes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        ButterKnife.bind(this, view);

        recipes.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.num_columns));
        recipes.setLayoutManager(layoutManager);

        recipes.setAdapter(new RecipesAdapter(this));

        return view;
    }

    @Override
    public void onRecipeClick(Recipe clickedRecipe) {
        Toast.makeText(getActivity(), "Recipe Card Clicked", Toast.LENGTH_SHORT).show();
    }
}
