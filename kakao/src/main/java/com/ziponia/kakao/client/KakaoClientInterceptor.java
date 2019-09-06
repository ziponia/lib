package com.ziponia.kakao.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class KakaoClientInterceptor implements Interceptor {

    private String restKey;
    private boolean debug;

    public KakaoClientInterceptor(String restKey, boolean debug) {
        this.restKey = restKey;
        this.debug = debug;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("Authorization", "KakaoAK " + restKey).build();
        System.out.println(request.url());
        return chain.proceed(request);
    }
}
