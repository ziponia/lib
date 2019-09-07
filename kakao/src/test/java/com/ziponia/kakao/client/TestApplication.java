package com.ziponia.kakao.client;

import com.ziponia.kakao.client.request.AddressSearchRequest;
import com.ziponia.kakao.client.request.Coord2RegionRequest;
import com.ziponia.kakao.client.request.TranslateRequest;
import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.AddressSearchResponse;
import com.ziponia.kakao.client.response.Coord2RegionResponse;
import com.ziponia.kakao.client.response.TranslateResponse;
import com.ziponia.kakao.client.response.WebSearchResponse;

import java.io.IOException;

public class TestApplication {

    public static KakaoClient kakaoClient;

    public static void main(String[] args) throws IOException {
        kakaoClient = KakaoClient.builder()
                .setRestKey("{your rest key}")
                .setAdminKey("{your admin key}")
                .build();

        webSearch();
        addressSearch();
        coord2Region();
        translate();
    }

    public static void webSearch() {
        // 웹 문서 검색
        WebSearchRequest request = new WebSearchRequest();
        request.setQuery("아이언맨");
        request.setPage(1);
        request.setSize(10);
        request.setSort(WebSearchRequest.Sort.ACCURACY);
        WebSearchResponse res = kakaoClient.webSearch(request);
        System.out.println(res.toString());
    }

    public static void addressSearch() {
        // 주소 검색
        AddressSearchRequest request = new AddressSearchRequest();
        request.setQuery("서울특별시 금천구 가산동 345-33");
        AddressSearchResponse res = kakaoClient.addressSearch(request);
        System.out.println(res.toString());
    }

    public static void coord2Region() {
        Coord2RegionRequest request = new Coord2RegionRequest();
        request.setX("127.1086228");
        request.setY("37.4012191");
        Coord2RegionResponse res = kakaoClient.coord2Region(request);
        System.out.println(res.toString());
    }

    public static void translate() {
        TranslateRequest request = new TranslateRequest();
        request.setQuery("저 앞에 있는것은 사과 입니까?");
        request.setSrc_lang("kr");
        request.setTarget_lang("en");
        TranslateResponse res = kakaoClient.translate(request);
        System.out.println(res.toString());
    }
}
