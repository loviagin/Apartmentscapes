package com.louagin.apartmentscapes.objects;

import android.graphics.drawable.Drawable;
import android.view.View;

public class ShopItem {

    private Drawable drawable;
    private String name;
    private String cost;
//    private View.OnClickListener  onClickListener;

    public ShopItem(Drawable drawable, String name, String cost
//            , View.OnClickListener onClickListener
    ) {
        this.drawable = drawable;
        this.name = name;
        this.cost = cost;
//        this.onClickListener = onClickListener;
    }

    public ShopItem(Drawable drawable) {
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

//    public View.OnClickListener getOnClickListener() {
//        return onClickListener;
//    }
//
//    public void setOnClickListener(View.OnClickListener onClickListener) {
//        this.onClickListener = onClickListener;
//    }
}
