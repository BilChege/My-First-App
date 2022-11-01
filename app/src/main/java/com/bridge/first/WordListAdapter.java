package com.bridge.first;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class WordListAdapter extends ListAdapter<Word, NameViewHolder> {

    protected WordListAdapter(@NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NameViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Word current = getItem(position);
        holder.bind(current.getMWord());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Word> {

        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getMWord().equals(newItem.getMWord());
        }
    }
}
