package fr.epsi.gomi;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class WasteSortingActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_sorting);

        MonAdaptateurDeListe adaptateur = new MonAdaptateurDeListe(this);
        setListAdapter(adaptateur);
    }
}