package com.ziponia.naver;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class NaverBaseClient {

    private static final String BASE_URL = "https://openapi.naver.com";
    public static String CLIENT_ID;
    public static String CLIENT_SECRET;

    public NaverRepository naverClient;

    public NaverBaseClient(final String clientId, final String clientSecret) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        naverClient = clientBuilder.baseUrl(BASE_URL)
                .build().create(NaverRepository.class);

        CLIENT_ID = clientId;
        CLIENT_SECRET = clientSecret;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String clientId;
        private String clientSecret;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public NaverClient build() {
            return new NaverClient(clientId, clientSecret);
        }
    }
}
