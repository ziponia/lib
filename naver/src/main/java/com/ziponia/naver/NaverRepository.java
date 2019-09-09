package com.ziponia.naver;

import com.ziponia.naver.news.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface NaverRepository {

    @GET("/v1/search/news.json")
    Call<NewsResponse> findNews(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @QueryMap Map<String, String> query
    );
}
