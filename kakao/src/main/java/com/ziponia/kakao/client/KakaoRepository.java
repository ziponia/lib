package com.ziponia.kakao.client;

import com.ziponia.kakao.client.response.*;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    @Multipart
    @POST("/v1/vision/thumbnail/crop")
    Call<ThumbnailCropResponse> thumbnailCrop(
            @Header("Authorization") String restKey,
            @PartMap() Map<String, RequestBody> query,
            @Part MultipartBody.Part file);
}
