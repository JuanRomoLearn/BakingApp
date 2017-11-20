package io.romo.bakingapp.rest.service;

import java.util.List;

import io.romo.bakingapp.model.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipesService {

    @GET("2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getRecipes();
}
