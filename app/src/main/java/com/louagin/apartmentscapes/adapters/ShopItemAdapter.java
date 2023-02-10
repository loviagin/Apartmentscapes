package com.louagin.apartmentscapes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.objects.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ItemViewHolder> {

    private List<ShopItem> list;
    private onShopItemCLickListener onShopItemCLickListener;
    private onShopItemBuyClickListener onShopItemBuyClickListener;
    private int isShop;

    public void setOnShopItemBuyClickListener(ShopItemAdapter.onShopItemBuyClickListener onShopItemBuyClickListener) {
        this.onShopItemBuyClickListener = onShopItemBuyClickListener;
    }

    public void setOnShopItemCLickListener(ShopItemAdapter.onShopItemCLickListener onShopItemCLickListener) {
        this.onShopItemCLickListener = onShopItemCLickListener;
    }

    public ShopItemAdapter(int isShop) {
        this.isShop = isShop;
        list = new ArrayList<>();
    }

    public void setList(List<ShopItem> list) {
        this.list = list;
    }

    public interface onShopItemCLickListener {
        void onShopItemClick(int position);
    }

    public interface onShopItemBuyClickListener {
        void onShopItemImageClick(int position);
        void onShopItemBuyClick(int position);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ShopItem shopItem = list.get(position);
        holder.imageButtonShopItem.setImageDrawable(shopItem.getDrawable());
        if (isShop > 1) {
            holder.textViewShopItemCost.setText(String.format("%s €", shopItem.getCost()));
            holder.textViewShopItemName.setText(shopItem.getName());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageButton imageButtonShopItem;
        private final TextView textViewShopItemName;
        private final TextView textViewShopItemCost;
        private LinearLayout linearLayoutItems;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonShopItem = itemView.findViewById(R.id.ibShopItem);
            textViewShopItemName = itemView.findViewById(R.id.tvShopItemName);
            linearLayoutItems = itemView.findViewById(R.id.llShopItemInfo);
            Button buttonShopItemBuy = itemView.findViewById(R.id.bShopItemBuy);
            textViewShopItemCost = itemView.findViewById(R.id.tvShopItemCost);
            imageButtonShopItem.setOnClickListener(view -> {
                if (onShopItemCLickListener != null) {
                    onShopItemCLickListener.onShopItemClick(getAdapterPosition());
                }
            });
            if (isShop > 1){
                linearLayoutItems.setVisibility(View.VISIBLE);
                imageButtonShopItem.setOnClickListener(view -> {
                    if (onShopItemBuyClickListener != null){
                        onShopItemBuyClickListener.onShopItemImageClick(getAdapterPosition());
                    }
                });
                buttonShopItemBuy.setOnClickListener(view -> {
                    if (onShopItemBuyClickListener != null) {
                        onShopItemBuyClickListener.onShopItemBuyClick(getAdapterPosition());
                    }
                });
            } else{
                linearLayoutItems.setVisibility(View.GONE);
            }
        }
    }
}
