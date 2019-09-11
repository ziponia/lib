package com.ziponia.google.youtube;

import com.ziponia.google.youtube.response.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface YoutubeRepository {

    @GET("/youtube/v3/search")
    Call<SearchResponse> search(
            @QueryMap Map<String, String> query
    );
}