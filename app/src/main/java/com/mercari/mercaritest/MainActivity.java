package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mercari.mercaritest.adapters.ItemAdapter;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.data.model.Response;
import com.mercari.mercaritest.network.Network;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    Network network;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((MercariApp) getApplicationContext()).getAppComponent().inject(this);
        Response response = network.getJsonResponse(this);

        for (int i = 0; i < 3; i++)
            Log.d("MainActivity", response.data.get(i).status);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(new ItemAdapter(response.data));
    }
}
