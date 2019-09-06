package com.ziponia.kakao.client;

import com.ziponia.kakao.client.response.WebSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface KakaoRepository {

    @GET("/v2/search/web")
    Call<WebSearchResponse> webSearch(
            @Header("Authorization") String restKey,
            @QueryMap Map<String, String> query
    );
}
