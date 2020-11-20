package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.*;
import static android.R.id.text1;

public class ProductActivity extends AppCompatActivity {

    ImageView photoProduit;
    TextView nomProduit;
    TextView catProduit;
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        photoProduit = findViewById(R.id.imgProduct);
        nomProduit = findViewById(R.id.nameProduit);
        catProduit = findViewById(R.id.catProduit);
        listView = (ListView) findViewById(R.id.list);

        Intent intent = getIntent();
        String barcode = intent.getStringExtra("barcode");

        RF rf = new RF("https://world.openfoodfacts.org");
        RetrofitProduct json = rf.getJson();
        Call<Product> call;
        call = json.getData(barcode);
        Product product = new Product();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(response.code() != 200){
                    return;
                }
                String photo = response.body().getUrl_image();
                String marque = response.body().getMarque();
                String cat = response.body().getCat_product();
                String[] composants = response.body().getComposants();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        text1,
                        composants);
                listView.setAdapter(adapter);

                Uri photoUri = Uri.parse(photo);
                photoProduit.setImageURI(photoUri);
                nomProduit.append(marque);
                catProduit.append(cat);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(getApplicationContext(), barcode, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void backClick(View view) {
        finish();
    }
}