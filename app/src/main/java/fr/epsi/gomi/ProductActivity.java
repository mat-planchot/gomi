package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.text1;

public class ProductActivity extends AppCompatActivity {

    ImageView photoProduit;
    TextView nomProduit;
    TextView brandsProduit;
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        photoProduit = findViewById(R.id.imgProduct);
        nomProduit = findViewById(R.id.nameProduit);
        brandsProduit = findViewById(R.id.catProduit);
        listView = (ListView) findViewById(R.id.list);

        Intent intent = getIntent();
        String barcode = intent.getStringExtra("barcode");

        RF rf = new RF("https://world.openfoodfacts.org/");
        RetrofitProduct json = rf.getJson();
        Call<OpenFood> call;
        call = json.getData(barcode);
        Product product = new Product();
        call.enqueue(new Callback<OpenFood>() {
            @Override
            public void onResponse(Call<OpenFood> call, Response<OpenFood> response) {
                if(response.code() != 200){
                    return;
                }
                String photo = response.body().getProduct().getImageFrontUrl();
                String nom = response.body().getProduct().getProductNameFr();
                String brands = response.body().getProduct().getBrands();
                String[] packagingTags = response.body().getProduct().getPackagingTags();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        text1,
                        packagingTags);
                listView.setAdapter(adapter);

                Uri photoUri = Uri.parse(photo);
                photoProduit.setImageURI(photoUri);
                nomProduit.append(nom);
                brandsProduit.append(brands);
            }

            @Override
            public void onFailure(Call<OpenFood> call, Throwable t) {
                Toast.makeText(getApplicationContext(), barcode, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void backClick(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("produit à rechercher");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.accueil:
                intent = new Intent(this, ScanListActivity.class);
                startActivity(intent);
                return true;
            case R.id.formation:
                intent = new Intent(this, FormationActivity.class);
                startActivity(intent);
                return true;
            case R.id.localisation:
                intent = new Intent(this, LocalisationActivity.class);
                startActivity(intent);
                return true;
            case R.id.parameter:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}