package com.ziponia.kakao.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.kakao.client.exception.KakaoClientBadRequestException;
import com.ziponia.kakao.client.exception.KakaoClientException;
import com.ziponia.kakao.client.exception.KakaoClientUnAuthorizeException;
import com.ziponia.kakao.client.request.AddressSearchRequest;
import com.ziponia.kakao.client.request.Coord2RegionRequest;
import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.AddressSearchResponse;
import com.ziponia.kakao.client.response.Coord2RegionResponse;
import com.ziponia.kakao.client.response.WebSearchResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

class KakaoClient {

    private static final String BASE_URL = "https://dapi.kakao.com";
    private KakaoRepository kakaoClient;
    private String REST_HEADER;

    private KakaoClient(final String restKey, final String adminKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit apiClient = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .baseUrl(BASE_URL)
                .build();

        kakaoClient = apiClient.create(KakaoRepository.class);

        this.REST_HEADER = "KakaoAK " + restKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public WebSearchResponse webSearch(WebSearchRequest request) {

        if (request.getQuery() == null || request.getQuery().length() == 0) {
            throw new KakaoClientBadRequestException("[query] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<WebSearchResponse> call = kakaoClient.webSearch(REST_HEADER, query);
        Response<WebSearchResponse> res;
        try {
            res = call.execute();
            if (!res.isSuccessful()) {
                if (res.code() == 400) {
                    throw new KakaoClientBadRequestException();
                } else if (res.code() == 401) {
                    throw new KakaoClientUnAuthorizeException();
                } else {
                    throw new KakaoClientException(res.message());
                }
            }
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AddressSearchResponse addressSearch(AddressSearchRequest request) {
        if (request.getQuery() == null || request.getQuery().length() == 0) {
            throw new KakaoClientBadRequestException("[query] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<AddressSearchResponse> call = kakaoClient.addressSearch(REST_HEADER, query);
        Response<AddressSearchResponse> res;
        try {
            res = call.execute();
            if (!res.isSuccessful()) {
                if (res.code() == 400) {
                    throw new KakaoClientBadRequestException();
                } else if (res.code() == 401) {
                    throw new KakaoClientUnAuthorizeException();
                } else {
                    throw new KakaoClientException(res.message());
                }
            }
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Coord2RegionResponse coord2Region(Coord2RegionRequest request) {
        if (request.getX() == null || request.getY().length() == 0) {
            throw new KakaoClientBadRequestException("[x],[y] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<Coord2RegionResponse> call = kakaoClient.coordsToRegion(REST_HEADER, query);
        Response<Coord2RegionResponse> res;
        try {
            res = call.execute();
            if (!res.isSuccessful()) {
                if (res.code() == 400) {
                    throw new KakaoClientBadRequestException();
                } else if (res.code() == 401) {
                    throw new KakaoClientUnAuthorizeException();
                } else {
                    throw new KakaoClientException(res.message());
                }
            }
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Builder {

        private String restKey;
        private String adminKey;

        Builder setRestKey(String restKey) {
            this.restKey = restKey;
            return this;
        }

        Builder setAdminKey(String adminKey) {
            this.adminKey = adminKey;
            return this;
        }

        public KakaoClient build() {
            return new KakaoClient(restKey, adminKey);
        }
    }
}
