package io.romo.bakingapp.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.romo.bakingapp.R;
import io.romo.bakingapp.adapter.RecipesAdapter;
import io.romo.bakingapp.model.Recipe;
import io.romo.bakingapp.rest.RecipesClient;
import io.romo.bakingapp.rest.service.RecipesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipesFragment extends Fragment
        implements Callback<List<Recipe>>, RecipesAdapter.RecipeItemListener {

    private static final String SAVED_LIST_POSITION = "list_position";

    @BindView(R.id.recipes) RecyclerView recipes;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    private RecipesAdapter adapter;
    private Parcelable recipesListPosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            recipesListPosition = savedInstanceState.getParcelable(SAVED_LIST_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        ButterKnife.bind(this, view);

        recipes.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.num_columns));
        recipes.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getActivity(), layoutManager.getOrientation());
        recipes.addItemDecoration(dividerItemDecoration);

        adapter = new RecipesAdapter(this);
        recipes.setAdapter(adapter);

        progressBar.setVisibility(View.VISIBLE);

        RecipesClient.createService(RecipesService.class)
                .getRecipes()
                .enqueue(this);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(SAVED_LIST_POSITION,
                recipes.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {
        progressBar.setVisibility(View.INVISIBLE);
        if (response.isSuccessful()) {
            adapter.replaceData(response.body());

            recipes.getLayoutManager().onRestoreInstanceState(recipesListPosition);
        } else {
            // TODO display error message
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<Recipe>> call, @NonNull Throwable t) {
        progressBar.setVisibility(View.INVISIBLE);

        // TODO display error message
    }

    @Override
    public void onRecipeClick(Recipe clickedRecipe) {
        Toast.makeText(getActivity(), "Recipe Clicked", Toast.LENGTH_SHORT).show();
    }
}
