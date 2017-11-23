package io.romo.bakingapp.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.romo.bakingapp.R;
import io.romo.bakingapp.model.RecipeIngredient;

public class RecipeIngredientAdapter extends RecyclerView.Adapter<RecipeIngredientAdapter.RecipeIngredientViewHolder> {

    List<RecipeIngredient> recipeIngredientList;

    public RecipeIngredientAdapter(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
    }

    @Override
    public RecipeIngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipe_ingredient, parent, false);
        return new RecipeIngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeIngredientViewHolder holder, int position) {
        RecipeIngredient recipeIngredient = recipeIngredientList.get(position);
        holder.bindRecipeIngredient(recipeIngredient);
    }

    @Override
    public int getItemCount() {
        return recipeIngredientList == null ? 0 : recipeIngredientList.size();
    }

    class RecipeIngredientViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipe_ingredient_obtained) CheckBox recipeIngredientObtained;
        @BindView(R.id.recipe_ingredient_name) TextView recipeIngredientName;
        @BindView(R.id.recipe_ingredient_quantity) TextView recipeIngredientQuantity;

        public RecipeIngredientViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindRecipeIngredient(RecipeIngredient recipeIngredient) {
            recipeIngredientName.setText(recipeIngredient.getIngredient());
            Resources resources = recipeIngredientQuantity.getContext().getResources();
            recipeIngredientQuantity.setText(resources.getString(R.string.recipe_ingredient,
                    recipeIngredient.getMeasure(), recipeIngredient.getQuantity()));
        }
    }
}
