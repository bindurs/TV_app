package com.ltrix.jk.tv_app.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bindu on 20/09/17.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://api.tvmaze.com";

    public static <S> S createService(Class<S> serviceClass) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();
        OkHttpClient client = new OkHttpClient();
//        client.setConnectTimeout(60, TimeUnit.SECONDS);
//        client.setReadTimeout(60, TimeUnit.SECONDS);
//        client.setWriteTimeout(60, TimeUnit.SECONDS);
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).client(client)
                .build();


        return adapter.create(serviceClass);
    }
}
