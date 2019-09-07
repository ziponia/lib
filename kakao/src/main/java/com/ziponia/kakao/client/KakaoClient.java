package com.ziponia.kakao.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.kakao.client.exception.KakaoClientBadRequestException;
import com.ziponia.kakao.client.exception.KakaoClientException;
import com.ziponia.kakao.client.exception.KakaoClientPermissionException;
import com.ziponia.kakao.client.exception.KakaoClientUnAuthorizeException;
import com.ziponia.kakao.client.request.AddressSearchRequest;
import com.ziponia.kakao.client.request.Coord2RegionRequest;
import com.ziponia.kakao.client.request.TranslateRequest;
import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.AddressSearchResponse;
import com.ziponia.kakao.client.response.Coord2RegionResponse;
import com.ziponia.kakao.client.response.TranslateResponse;
import com.ziponia.kakao.client.response.WebSearchResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

public class KakaoClient {

    private static final String BASE_URL = "https://kapi.kakao.com";
    private static final String BASE_URL_V2 = "https://dapi.kakao.com";

    private KakaoRepository kakaoClientV2;
    private KakaoRepository kakaoClient;
    private String REST_HEADER;

    private KakaoClient(final String restKey, final String adminKey) {
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

    public WebSearchResponse webSearch(WebSearchRequest request) {

        if (request.getQuery() == null || request.getQuery().length() == 0) {
            throw new KakaoClientBadRequestException("[query] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<WebSearchResponse> call = kakaoClientV2.webSearch(REST_HEADER, query);
        return exec(call);
    }

    public AddressSearchResponse addressSearch(AddressSearchRequest request) {
        if (request.getQuery() == null || request.getQuery().length() == 0) {
            throw new KakaoClientBadRequestException("[query] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<AddressSearchResponse> call = kakaoClientV2.addressSearch(REST_HEADER, query);
        return exec(call);
    }

    public Coord2RegionResponse coord2Region(Coord2RegionRequest request) {
        if (request.getX() == null || request.getY().length() == 0) {
            throw new KakaoClientBadRequestException("[x],[y] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<Coord2RegionResponse> call = kakaoClientV2.coordsToRegion(REST_HEADER, query);
        return exec(call);
    }

    public TranslateResponse translate(TranslateRequest request) {
        if (request.getQuery() == null || request.getSrc_lang() == null || request.getTarget_lang() == null) {
            throw new KakaoClientBadRequestException("필수 파라메터가 선언되어있지 않습니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<TranslateResponse> call = kakaoClient.translateLanguage(REST_HEADER, query);
        return exec(call);
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
}
