package io.romo.bakingapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.romo.bakingapp.R;
import io.romo.bakingapp.model.Recipe;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    private List<Recipe> recipes;
    private RecipeItemListener recipeItemListener;

    public interface RecipeItemListener {
        void onRecipeClick(Recipe clickedRecipe);
    }

    public RecipesAdapter(RecipeItemListener recipeItemListener) {
        this.recipeItemListener = recipeItemListener;
    }

    public void replaceData(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipe, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.bindRecipe(recipe);
    }

    @Override
    public int getItemCount() {
        return recipes == null ? 0 : recipes.size();
    }

    class RecipesViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.name) TextView name;
        @BindView(R.id.servings) TextView servings;

        private Recipe recipe;

        public RecipesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recipeItemListener.onRecipeClick(recipe);
        }

        public void bindRecipe(Recipe recipe) {
            this.recipe = recipe;
            name.setText(recipe.getName());
            servings.setText(
                    itemView.getContext().getString(R.string.servings, recipe.getServings())
            );
        }
    }
}
