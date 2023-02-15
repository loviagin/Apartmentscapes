package com.louagin.apartmentscapes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.objects.PlayItem;

import java.util.List;

public class PlayGameAdapter extends RecyclerView.Adapter<PlayGameAdapter.gameViewHolder> {

    private List<PlayItem> playItems;

    public void setList(List<PlayItem> playItems) {
        this.playItems = playItems;
    }

    @NonNull
    @Override
    public gameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        return new gameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gameViewHolder holder, int position) {
        PlayItem item = playItems.get(position);
        holder.imageView.setImageDrawable(item.getDrawableImage());
        holder.textViewUsername.setText(item.getUsername() + " " + item.getCost() + "€");
        holder.textViewName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return playItems.size();
    }

    class gameViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewUsername;
        private ImageView imageView;

        public gameViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.tvPlayName);
            textViewUsername = itemView.findViewById(R.id.tvPlayUserName);
            imageView = itemView.findViewById(R.id.ivPlayItem);
        }
    }
}
