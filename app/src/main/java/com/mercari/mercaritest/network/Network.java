package com.mercari.mercaritest.network;

import android.content.Context;

import com.google.gson.Gson;
import com.mercari.mercaritest.data.model.Response;

import java.io.IOException;
import java.io.InputStream;

public class Network {

    public Response getJsonResponse(Context context){
        // 1 networking code will replace this
        String json = loadJSONFromAsset("all.json", context);

        // 2 parse json into model objects
        return new Gson().fromJson(json, Response.class);
    }

    private String loadJSONFromAsset(String fileName, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
