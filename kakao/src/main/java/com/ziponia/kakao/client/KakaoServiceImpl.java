package com.ziponia.kakao.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.kakao.client.exception.KakaoClientBadRequestException;
import com.ziponia.kakao.client.exception.KakaoClientException;
import com.ziponia.kakao.client.exception.KakaoClientUnAuthorizeException;
import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.WebSearchResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

public class KakaoServiceImpl implements KakaoService {

    private static final String BASE_URL = "https://dapi.kakao.com";
    private KakaoRepository kakaoClient;
    private boolean debug = false;

    public KakaoServiceImpl(final String restKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new KakaoClientInterceptor(restKey, debug));
        Retrofit apiClient = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .baseUrl(BASE_URL)
                .build();

        kakaoClient = apiClient.create(KakaoRepository.class);
    }

    @Override
    public WebSearchResponse webSearch(WebSearchRequest request) {

        if (request.getQuery() == null || request.getQuery().length() == 0) {
            throw new KakaoClientBadRequestException("[query] 필드는 필수값입니다.");
        }
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>(){};
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<WebSearchResponse> call = kakaoClient.webSearch(query);
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

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
