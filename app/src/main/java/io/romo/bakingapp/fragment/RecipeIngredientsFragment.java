package io.romo.bakingapp.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.romo.bakingapp.R;
import io.romo.bakingapp.adapter.RecipeIngredientAdapter;
import io.romo.bakingapp.model.Recipe;

public class RecipeIngredientsFragment extends Fragment {

    private static final String ARG_RECIPE = "recipe";

    private static final String LIST_POSITION_STATE = "list_position_state";

    @BindView(R.id.recipe_ingredients) RecyclerView recipeIngredients;

    private RecipeIngredientAdapter adapter;
    private Recipe recipe;
    private Parcelable listPositionState;

    public static RecipeIngredientsFragment newInstance(Recipe recipe) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_RECIPE, recipe);

        RecipeIngredientsFragment fragment = new RecipeIngredientsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipe = getArguments().getParcelable(ARG_RECIPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_ingredients, container, false);
        ButterKnife.bind(this, view);

        recipeIngredients.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recipeIngredients.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getActivity(), layoutManager.getOrientation());
        recipeIngredients.addItemDecoration(dividerItemDecoration);

        adapter = new RecipeIngredientAdapter(recipe.getIngredients());
        recipeIngredients.setAdapter(adapter);

        if (savedInstanceState != null) {
            listPositionState = savedInstanceState.getParcelable(LIST_POSITION_STATE);
            recipeIngredients.getLayoutManager().onRestoreInstanceState(listPositionState);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(LIST_POSITION_STATE,
                recipeIngredients.getLayoutManager().onSaveInstanceState());
    }
}
