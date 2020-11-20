package fr.epsi.gomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void continueClick(View view) {
        Intent intent = new Intent(HomePageActivity.this, ChoiceConnexionActivity.class);
        startActivity(intent);
    }
}