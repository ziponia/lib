package com.ziponia.kakao.client;

import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.WebSearchResponse;

import java.io.IOException;

public class TestApplication {

    public static void main(String[] args) throws IOException {
        KakaoClient kakaoClient = KakaoClient.builder()
                .setRestKey("{your rest key}")
                .setAdminKey("{your admin key}")
                .build();

        // 웹 문서 검색
        WebSearchRequest request = new WebSearchRequest();
        request.setQuery("아이언맨");
        request.setPage(1);
        request.setSize(10);
        request.setSort(WebSearchRequest.Sort.ACCURACY);
        WebSearchResponse res = kakaoClient.webSearch(request);
        System.out.println(res.toString());
    }
}
