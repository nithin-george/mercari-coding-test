package com.mercari.mercaritest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.mercari.mercaritest.R;

public class ItemViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.photo)
    public ImageView photo;
    @BindView(R.id.sold)
    public ImageView sold;
    @BindView(R.id.price)
    public TextView price;
    @BindView(R.id.name)
    public TextView name;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
