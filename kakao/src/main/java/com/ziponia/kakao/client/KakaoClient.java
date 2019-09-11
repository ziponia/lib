package com.ziponia.kakao.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.kakao.client.exception.*;
import com.ziponia.kakao.client.request.*;
import com.ziponia.kakao.client.response.*;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class KakaoClient extends KakaoBaseClient {

    protected KakaoClient(String restKey, String adminKey) {
        super(restKey, adminKey);
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

    public ThumbnailCropResponse thumbnailCrop(ThumbnailCropRequest request) {
        Map<String, RequestBody> query = new HashMap<>();

        query.put("width", RequestBody.create(
                MultipartBody.FORM, request.getWidth().toString()
        ));
        query.put("height", RequestBody.create(
                MultipartBody.FORM, request.getHeight().toString()
        ));

        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse("image/*"),
                        request.getFile()
                );

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", request.getFile().getName(), requestFile);
        Call<ThumbnailCropResponse> call = kakaoClient.thumbnailCrop(REST_HEADER, query, body);
        return exec(call);
    }
}
