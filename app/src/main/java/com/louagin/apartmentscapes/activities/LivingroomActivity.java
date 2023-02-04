package com.louagin.apartmentscapes.activities;

import static com.louagin.apartmentscapes.auth.Credential.money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.louagin.apartmentscapes.R;

public class LivingroomActivity extends AppCompatActivity {

    private TextView textViewMoney;

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
        setContentView(R.layout.activity_livingroom);

        textViewMoney = findViewById(R.id.tvMoney);
        textViewMoney.setText(String.valueOf(money));
    }
}