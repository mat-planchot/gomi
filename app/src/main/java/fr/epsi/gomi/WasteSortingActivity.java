package fr.epsi.gomi;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

public class WasteSortingActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_sorting);

        MonAdaptateurDeListe adaptateur = new MonAdaptateurDeListe(this);
        setListAdapter(adaptateur);
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