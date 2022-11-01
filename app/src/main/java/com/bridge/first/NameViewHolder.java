package com.bridge.first;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private TextView wordItemView;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.name);
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    static NameViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
        return new NameViewHolder(view);
    }
}
