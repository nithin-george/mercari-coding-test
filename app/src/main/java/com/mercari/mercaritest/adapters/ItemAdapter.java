package com.mercari.mercaritest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;

import java.util.List;
import java.util.Locale;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{
    private List<Item> items;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = items.get(position);

        if (item.status != null && item.status.equals("sold_out"))
            holder.sold.setVisibility(View.VISIBLE);
        else
            holder.sold.setVisibility(View.GONE);
        if (item.photo != null)
            Glide.with(holder.photo.getContext())
                    .load(item.photo)
                    .bitmapTransform(new RoundedCornersTransformation(holder.photo.getContext(),dpToPixels(6, holder.photo.getContext()),0))
                    .into(holder.photo);
        if (item.name != null)
            holder.name.setText(item.name);
        holder.price.setText(String.format(Locale.US,"$%d",item.price));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private int dpToPixels(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
