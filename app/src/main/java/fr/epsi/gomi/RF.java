package fr.epsi.gomi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RF {
    private Gson gson;
    private Retrofit retrofit;
    private RetrofitProduct json;

    public RF(String url){
        gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
    public RetrofitProduct getJson(){
        return this.retrofit.create(RetrofitProduct.class);
    }
}