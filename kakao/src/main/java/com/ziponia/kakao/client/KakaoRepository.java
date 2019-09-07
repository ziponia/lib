package com.ziponia.kakao.client;

import com.ziponia.kakao.client.request.TranslateRequest;
import com.ziponia.kakao.client.response.AddressSearchResponse;
import com.ziponia.kakao.client.response.Coord2RegionResponse;
import com.ziponia.kakao.client.response.TranslateResponse;
import com.ziponia.kakao.client.response.WebSearchResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface KakaoRepository {

    @GET("/v2/search/web")
    Call<WebSearchResponse> webSearch(
            @Header("Authorization") String restKey,
            @QueryMap Map<String, String> query
    );

    @GET("/v2/local/search/address.json")
    Call<AddressSearchResponse> addressSearch(
            @Header("Authorization") String restKey,
            @QueryMap Map<String, String> query
    );

    @GET("/v2/local/geo/coord2regioncode.json")
    Call<Coord2RegionResponse> coordsToRegion(
            @Header("Authorization") String restKey,
            @QueryMap Map<String, String> query
    );

    @POST("/v1/translation/translate")
    Call<TranslateResponse> translateLanguage(
            @Header("Authorization") String restKey,
            @QueryMap Map<String, String> query
    );
}
