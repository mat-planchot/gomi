package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class WasteSorting extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_sorting);
        String[] values = new String[] { "verre", "textile", "papier / carton"  };

        ArrayAdapter<String> adapter = new MonAdaptateurDeListe(this,
                android.R.layout.rowlayout, values);
        setListAdapter(adapter);
    }
}