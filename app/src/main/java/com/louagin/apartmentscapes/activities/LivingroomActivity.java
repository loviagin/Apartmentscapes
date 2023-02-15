package com.louagin.apartmentscapes.activities;

import static com.louagin.apartmentscapes.auth.Credential.database;
import static com.louagin.apartmentscapes.auth.Credential.money;
import static com.louagin.apartmentscapes.auth.Credential.preferences;
import static com.louagin.apartmentscapes.auth.Credential.rooms;
import static com.louagin.apartmentscapes.auth.Credential.values;
import static com.louagin.apartmentscapes.services.DBHelper.ID_ROOM;
import static com.louagin.apartmentscapes.services.DBHelper.IS_OPEN;
import static com.louagin.apartmentscapes.services.DBHelper.LR_ROBOT;
import static com.louagin.apartmentscapes.services.DBHelper.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.adapters.ShopItemAdapter;
import com.louagin.apartmentscapes.objects.ShopItem;
import com.louagin.apartmentscapes.services.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class LivingroomActivity extends AppCompatActivity {

    private String TAG = "Livingroom_Activity";
    private TextView textViewMoney;
    private ShapeableImageView imageViewMenu;
    private ShopItemAdapter shopItemAdapter;
    private RecyclerView recyclerViewShopItem, recyclerViewItems;
    private ImageButton buttonShop, buttonCloseShop;
    private CardView cardViewShop;
    private List<ShopItem> shopItemList;
    private List<ShopItem> shopItems;
    private ImageView imageViewMain;
    private ImageView imageViewRobot1, imageViewRobot2, imageViewRobot3;
    private Button buttonStartGame;

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
        setContentView(R.layout.activity_livingroom);

        textViewMoney = findViewById(R.id.tvMoney);
        imageViewMenu = findViewById(R.id.ivAvatar);
        recyclerViewShopItem = findViewById(R.id.rvShop);
        buttonShop = findViewById(R.id.bShop);
        cardViewShop = findViewById(R.id.cvShop);
        buttonCloseShop = findViewById(R.id.ibCloseShop);
        imageViewMain = findViewById(R.id.ivLivingroomMain);
        recyclerViewItems = findViewById(R.id.rvShopItems);
        imageViewRobot1 = findViewById(R.id.ivLRrobot1);
        imageViewRobot2 = findViewById(R.id.ivLRrobot2);
        imageViewRobot3 = findViewById(R.id.ivLRrobot3);
        buttonStartGame = findViewById(R.id.bStartGame);
        buttonPrev = findViewById(R.id.ibPrevRoom);
        buttonNext = findViewById(R.id.ibNextRoom);

        Cursor cursor = database.query(TABLE_NAME, null, "id_room = 1", null, null, null, null);
        if (cursor.moveToFirst()) {
            int lr_robot = cursor.getColumnIndex(LR_ROBOT);
            switch (cursor.getInt(lr_robot)) {
                case 1:
                    imageViewRobot1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    imageViewRobot2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    imageViewRobot3.setVisibility(View.VISIBLE);
            }
        }
        cursor.close();

        shopItemList = new ArrayList<>();
        shopItems = new ArrayList<>();

        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        textViewMoney.setText(String.format(getString(R.string.money_str), String.valueOf(money)));
        imageViewMenu.setOnClickListener(viewClickListener);
        buttonShop.setOnClickListener(v -> showShop());
        buttonCloseShop.setOnClickListener(view -> cardViewShop.setVisibility(View.GONE));
        buttonStartGame.setOnClickListener(view -> {
            startActivity(new Intent(this, LivingroomPlayActivity.class));
        });
        buttonPrev.setOnClickListener(view -> {
            startActivity(new Intent(this, WorkroomActivity.class));
            overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
        });
        buttonNext.setOnClickListener(view -> {
            startActivity(new Intent(this, KitchenActivity.class));
            overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
        });
    }

    private void showShop() {
        shopItemAdapter = new ShopItemAdapter(1);
        recyclerViewShopItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.robot)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        shopItemList.add(new ShopItem(getResources().getDrawable(R.drawable.ic_lock)));
        //
        shopItemAdapter.setList(shopItemList);
        recyclerViewShopItem.setAdapter(shopItemAdapter);

        shopItemAdapter.setOnShopItemCLickListener(new ShopItemAdapter.onShopItemCLickListener() {
            @Override
            public void onShopItemClick(int position) {
                shopItemAdapter = new ShopItemAdapter(2);
                switch (position) {
                    case 0:
                        shopItems.clear();
                        shopItems.add(new ShopItem(getResources().getDrawable(R.drawable.robot), "Робот пылесос 1", "800"));
                        shopItems.add(new ShopItem(getResources().getDrawable(R.drawable.robot1), "Робот пылесос 2", "1000"));
                        shopItems.add(new ShopItem(getResources().getDrawable(R.drawable.robot2), "Робот пылесос 3", "1300"));
                        shopItemAction(position);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                }
                shopItemAdapter.setList(shopItems);
//                shopItemAdapter.notifyAll();
                recyclerViewItems.setAdapter(shopItemAdapter);
                cardViewShop.setVisibility(View.GONE);
                recyclerViewItems.setVisibility(View.VISIBLE);
            }
        });

        cardViewShop.setVisibility(View.VISIBLE);
    }

    private void shopItemAction(int object) {
        shopItemAdapter.setOnShopItemBuyClickListener(new ShopItemAdapter.onShopItemBuyClickListener() {
            @Override
            public void onShopItemImageClick(int position) {
                switch (object) {
                    case 0:
                        if (position == 0) {
                            imageViewRobot2.setVisibility(View.GONE);
                            imageViewRobot3.setVisibility(View.GONE);
                            imageViewRobot1.setVisibility(View.VISIBLE);
                        } else if (position == 1) {
                            imageViewRobot2.setVisibility(View.VISIBLE);
                            imageViewRobot3.setVisibility(View.GONE);
                            imageViewRobot1.setVisibility(View.GONE);
                        } else {
                            imageViewRobot2.setVisibility(View.GONE);
                            imageViewRobot3.setVisibility(View.VISIBLE);
                            imageViewRobot1.setVisibility(View.GONE);
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                }
            }

            @Override
            public void onShopItemBuyClick(int position) {
                boolean isBought = false;
                values.clear();
                switch (object) {
                    case 0:
                        if (position == 0 && money >= 800) {
                            money -= 800;
                            imageViewRobot2.setVisibility(View.GONE);
                            imageViewRobot3.setVisibility(View.GONE);
                            imageViewRobot1.setVisibility(View.VISIBLE);
                            values.put(LR_ROBOT, 1);
                            isBought = true;
                        } else if (position == 1 && money >= 1000) {
                            money -= 1000;
                            imageViewRobot2.setVisibility(View.VISIBLE);
                            imageViewRobot3.setVisibility(View.GONE);
                            imageViewRobot1.setVisibility(View.GONE);
                            values.put(LR_ROBOT, 2);
                            isBought = true;
                        } else if (position == 2 && money >= 1300) {
                            money -= 1300;
                            imageViewRobot2.setVisibility(View.GONE);
                            imageViewRobot3.setVisibility(View.VISIBLE);
                            imageViewRobot1.setVisibility(View.GONE);
                            values.put(LR_ROBOT, 3);
                            isBought = true;
                        } else {
                            Toast.makeText(LivingroomActivity.this, "Вам не хватает средств", Toast.LENGTH_SHORT).show();
                            isBought = false;
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                }
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        preferences.edit().putInt("money", money).apply();
                        textViewMoney.setText(String.valueOf(money) + "€");
                        database.update(DBHelper.TABLE_NAME, values, "id_room = 1", null);
                    }
                });
                if (isBought) {
                    recyclerViewItems.setVisibility(View.GONE);
                    thread.start();
                    isBought = false;
                }

            }
        });
    }

    View.OnClickListener viewClickListener = this::showPopupMenu;

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.account_menu);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.m_home:
                            startActivity(new Intent(LivingroomActivity.this, HomeActivity.class));
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