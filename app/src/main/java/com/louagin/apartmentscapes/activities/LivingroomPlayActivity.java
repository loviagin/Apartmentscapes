package com.louagin.apartmentscapes.activities;

import static com.louagin.apartmentscapes.auth.Credential.money;
import static com.louagin.apartmentscapes.auth.Credential.preferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.adapters.PlayGameAdapter;
import com.louagin.apartmentscapes.objects.PlayItem;
import com.louagin.apartmentscapes.services.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LivingroomPlayActivity extends AppCompatActivity {

    //    private PlayGameAdapter playGameAdapter;
//    private RecyclerView recyclerViewItems;
    private final String TAG = "Livingroom_Play_Activity";
    private TextView textViewMoney, textViewTimer, textViewName, textViewUsername, textViewAddedMoney;
    private ImageView imageView, imageViewCup, imageViewAircondition, imageViewTeapot, imageViewRug, imageViewVase;
    private ShapeableImageView imageViewAvatar;
    private List<PlayItem> playItems;
    private List<ImageView> listItems;
    private int cost = 0;
    private volatile boolean running = false;

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
        setContentView(R.layout.activity_livingroom_play);

//        recyclerViewItems = findViewById(R.id.rvLivingroomPlayItems);
        textViewMoney = findViewById(R.id.tvPlayMoney);
        imageViewAvatar = findViewById(R.id.ivPlayAvatar);
        textViewName = findViewById(R.id.tvPlayName);
        textViewUsername = findViewById(R.id.tvPlayUserName);
        textViewTimer = findViewById(R.id.tvLivingroomPlayTime);
        imageViewAircondition = findViewById(R.id.ivPlayLRaircondition);
        imageViewCup = findViewById(R.id.ivPlayLRcup);
        imageViewRug = findViewById(R.id.ivPlayLRrug);
        imageViewTeapot = findViewById(R.id.ivPlayLRteapot);
        imageViewVase = findViewById(R.id.ivPlayLRvase);
        imageView = findViewById(R.id.ivPlayItem);
        textViewAddedMoney = findViewById(R.id.tvPlayAddedMoney);

        playItems = new ArrayList<>();
        playItems.add(new PlayItem("Anya", "Ваза", getResources().getDrawable(R.drawable.vase), 200));
        playItems.add(new PlayItem("Valya", "Кондиционер", getResources().getDrawable(R.drawable.aircondition), 700));
        playItems.add(new PlayItem("Sasha", "Плед", getResources().getDrawable(R.drawable.rug), 100));
        playItems.add(new PlayItem("Ivan", "Чайник", getResources().getDrawable(R.drawable.teapot), 120));
        playItems.add(new PlayItem("Ilya", "Чашка", getResources().getDrawable(R.drawable.cup), 80));

        listItems = new ArrayList<>();
        listItems.add(imageViewVase);
        listItems.add(imageViewAircondition);
        listItems.add(imageViewRug);
        listItems.add(imageViewTeapot);
        listItems.add(imageViewCup);

        Thread threadTimer = new Thread(() -> {
            for (int time = 60; time >= 0; time--) {
                textViewTimer.setText(String.format(getResources().getString(R.string.time_str), "" + time / 60, "" + (time - (time / 60 * 60))));
                try {
                    Object obj = new Object();
                    synchronized (obj) {
                        obj.wait(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            startActivity(new Intent(getApplicationContext(), LivingroomActivity.class));
        });
        threadTimer.start();

        nextItemGame();

        imageViewAvatar.setOnClickListener(viewClickListener);
        textViewMoney.setText(String.valueOf(money) + "€");

//        threadAddedMoney.start();
//        playGameAdapter = new PlayGameAdapter();
//        playItems = new ArrayList<>();
//        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playItems.add(new PlayItem("Anya", "Пылесос", getResources().getDrawable(R.drawable.robot), 1000));
//        playGameAdapter.setList(playItems);
//        recyclerViewItems.setAdapter(playGameAdapter);
    }

//    Thread threadAddedMoney = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            if (!running) {
//                textViewAddedMoney.setVisibility(View.GONE);
//                return;
//            }
//            textViewAddedMoney.setVisibility(View.VISIBLE);
//            textViewAddedMoney.setText(String.format("+ %s€", "" + cost));
//            try {
//                Object obj = new Object();
//                synchronized (obj) {
//                    obj.wait(4000);
//                }
//            } catch (InterruptedException e) {
//                Log.d(TAG, "Новый объект нажат");
//            }
//            textViewAddedMoney.setVisibility(View.GONE);
//        }
//    });

    private void nextItemGame() {
        Log.d(TAG, "NextItem Game");
        if (playItems.size() > 0) {
            int item = Utils.randomInt(0, playItems.size());
            PlayItem playItem = playItems.get(item);
            textViewName.setText(playItem.getName());
            textViewUsername.setText(String.format("%s %s🪙", playItem.getUsername(), playItem.getCost()));
            imageView.setImageDrawable(playItem.getDrawableImage());
            listItems.get(item).setOnClickListener(view -> {
                money += playItem.getCost();
                textViewMoney.setText(money + "€");
                listItems.get(item).setVisibility(View.GONE);
                playItems.remove(item);
                listItems.remove(item);
                nextItemGame();
            });
        } else {
//            Toast.makeText(this, "🎉🎉Победа🎉🎉", Toast.LENGTH_SHORT).show();
            int profit = money - preferences.getInt("money", 0);
            new AlertDialog.Builder(this)
                    .setTitle("\uD83C\uDF89\uD83C\uDF89Победа\uD83C\uDF89\uD83C\uDF89")
                    .setMessage(String.format("Вы нашли все предметы и заработали %s€", profit))

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("Продолжить", (dialog, which) -> startActivity(new Intent(LivingroomPlayActivity.this, LivingroomActivity.class)))

                    // A null listener allows the button to dismiss the dialog and take no further action.
//                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(getResources().getDrawable(R.drawable.ic_win))
                    .show();
//            startActivity(new Intent(this, LivingroomActivity.class));
        }
    }

    View.OnClickListener viewClickListener = this::showPopupMenu;

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.play_menu);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.item_home:
                            startActivity(new Intent(LivingroomPlayActivity.this, HomeActivity.class));
                            return true;
                        case R.id.item_exit:
                            startActivity(new Intent(LivingroomPlayActivity.this, LivingroomActivity.class));
                            return true;
                        default:
                            return false;
                    }
                });

//        popupMenu.setOnDismissListener(menu -> Toast.makeText(getApplicationContext(), "onDismiss",
//                Toast.LENGTH_SHORT).show());
        popupMenu.show();
    }

}