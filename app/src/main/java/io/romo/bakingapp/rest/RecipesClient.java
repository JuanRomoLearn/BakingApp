package io.romo.bakingapp.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipesClient {

    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient httpClient =
            new OkHttpClient.Builder().build();

    private static Retrofit retrofit = builder.client(httpClient).build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
