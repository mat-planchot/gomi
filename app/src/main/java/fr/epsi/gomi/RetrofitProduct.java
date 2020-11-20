package fr.epsi.gomi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitProduct {

    @GET("/api/v0/product/{barcode}")
    Call<Product> getData(@Path("barcode") String id_product);
}
