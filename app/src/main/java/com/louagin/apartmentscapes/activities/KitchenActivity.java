package com.louagin.apartmentscapes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.louagin.apartmentscapes.R;

public class KitchenActivity extends AppCompatActivity {

    private ImageButton buttonPrev, buttonNext;

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
        setContentView(R.layout.activity_kitchen);

        buttonPrev = findViewById(R.id.ibPrevRoom);
        buttonNext = findViewById(R.id.ibNextRoom);

        buttonNext.setVisibility(View.GONE);
        buttonPrev.setOnClickListener(view -> {
            startActivity(new Intent(this, LivingroomActivity.class));
            overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
        });
    }
}