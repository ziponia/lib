package com.ziponia.kakao.client;

import com.ziponia.kakao.client.request.AddressSearchRequest;
import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.AddressSearchResponse;
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
}
