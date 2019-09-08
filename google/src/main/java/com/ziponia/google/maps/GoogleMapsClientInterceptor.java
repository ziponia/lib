package com.ziponia.google.maps;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GoogleMapsClientInterceptor implements Interceptor {

    private String apiKey;
    public GoogleMapsClientInterceptor(final String apiKey) {
        this.apiKey = apiKey;
    }

    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl originalHttpUrl = request.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", apiKey)
                .build();

        Request.Builder requestBuilder = request.newBuilder()
                .url(url);
        Request newRequest = requestBuilder.build();

        System.out.println(newRequest.url());
        return chain.proceed(newRequest);
    }
}
