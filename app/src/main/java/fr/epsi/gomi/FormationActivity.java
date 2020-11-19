package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
    }

    public void begin(View view) {
        Intent intent = new Intent(this, WasteSortingActivity.class);
        startActivity(intent);
    }
}