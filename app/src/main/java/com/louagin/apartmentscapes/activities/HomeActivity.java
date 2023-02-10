package com.louagin.apartmentscapes.activities;

import static com.louagin.apartmentscapes.auth.Credential.database;
import static com.louagin.apartmentscapes.auth.Credential.is_new;
import static com.louagin.apartmentscapes.auth.Credential.money;
import static com.louagin.apartmentscapes.auth.Credential.preferences;
import static com.louagin.apartmentscapes.auth.Credential.rooms;
import static com.louagin.apartmentscapes.services.DBHelper.IS_OPEN;
import static com.louagin.apartmentscapes.services.DBHelper.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.auth.Credential;

public class HomeActivity extends AppCompatActivity {

    private Button buttonNewGame;
    private Button buttonContinueGame;

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonNewGame = findViewById(R.id.bNewGame);
        buttonContinueGame = findViewById(R.id.bContGame);

        if (is_new) {
            buttonContinueGame.setVisibility(View.GONE);
        }

        buttonNewGame.setOnClickListener(view -> onGameNewStart());
        buttonContinueGame.setOnClickListener(view -> onGameContinue());
    }

    private void onGameNewStart() {
        Credential.clear();
        preferences.edit().putBoolean("is_new", false).apply();
        MainActivity.loadData(true, this);
//        preferences.edit().putInt("money", 1000).apply();
//        money = 1000;
        startActivity(new Intent(this, LivingroomActivity.class));
    }

    private void onGameContinue() {
        startActivity(new Intent(this, LivingroomActivity.class));
    }
}