package com.ziponia.kakao.client;

import com.ziponia.kakao.client.exception.KakaoClientBadRequestException;
import com.ziponia.kakao.client.exception.KakaoClientException;
import com.ziponia.kakao.client.exception.KakaoClientPermissionException;
import com.ziponia.kakao.client.exception.KakaoClientUnAuthorizeException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public abstract class KakaoBaseClient {

    private static final String BASE_URL = "https://kapi.kakao.com";
    private static final String BASE_URL_V2 = "https://dapi.kakao.com";

    protected KakaoRepository kakaoClientV2;
    protected KakaoRepository kakaoClient;
    protected String REST_HEADER;

    protected KakaoBaseClient(final String restKey, final String adminKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        kakaoClient = clientBuilder.baseUrl(BASE_URL)
                .build().create(KakaoRepository.class);
        kakaoClientV2 = clientBuilder.baseUrl(BASE_URL_V2)
                .build().create(KakaoRepository.class);

        this.REST_HEADER = "KakaoAK " + restKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String restKey;
        private String adminKey;

        public Builder setRestKey(String restKey) {
            this.restKey = restKey;
            return this;
        }

        public Builder setAdminKey(String adminKey) {
            this.adminKey = adminKey;
            return this;
        }

        public KakaoClient build() {
            return new KakaoClient(restKey, adminKey);
        }
    }

    protected <T> T exec(Call<T> call) {
        Response<T> res;
        try {
            res = call.execute();
            if (!res.isSuccessful()) {
                if (res.code() == 400) {
                    throw new KakaoClientBadRequestException();
                } else if (res.code() == 401) {
                    throw new KakaoClientUnAuthorizeException();
                } else if (res.code() == 403) {
                    throw new KakaoClientPermissionException();
                } else if (res.code() == 500 || res.code() == 502) {
                    throw new KakaoClientException();
                } else {
                    throw new KakaoClientException(res.message() + "[" + res.code() + "]");
                }
            }
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
