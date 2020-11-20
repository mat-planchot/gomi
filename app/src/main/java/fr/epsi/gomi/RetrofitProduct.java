package fr.epsi.gomi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitProduct {

    @GET("737628064502")
    Call<Products> getData();

}
