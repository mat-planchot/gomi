package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListProductActivity extends AppCompatActivity {

    ImageView photoProduit;
    TextView nomProduit;
    TextView catProduit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        photoProduit = findViewById(R.id.imgProduct);
        nomProduit = findViewById(R.id.nameProduit);
        catProduit = findViewById(R.id.catProduit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://world.openfoodfacts.org/api/v0/product")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitProduct retrofitProduct = retrofit.create(RetrofitProduct.class);
        Call<Products> call = retrofitProduct.getData();

        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if(response.code() != 200){
                    return;
                }

                String photo = response.body().getUrl_image();
                String marque = response.body().getMarque();
                String cat = response.body().getCat_product();

                //photoProduit.setImageURI(photo);
                nomProduit.append(marque);
                catProduit.append(cat);
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {

            }
        });
    }



}