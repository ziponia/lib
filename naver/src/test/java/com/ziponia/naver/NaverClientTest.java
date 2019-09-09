package com.ziponia.naver;

import com.ziponia.naver.news.NewsRequest;
import com.ziponia.naver.news.NewsResponse;

class NaverClientTest {

    private static NaverClient naverClient;

    public static void main(String[] args) {
        naverClient = NaverClient.builder()
                .clientId("{your naver client id}")
                .clientSecret("{your naver client secret}")
                .build();

        // 뉴스 찾기
        findNews();
    }

    private static void findNews() {
        NewsRequest request = NewsRequest.builder()
                .query("갤럭시 10")
                .build();
        NewsResponse res = naverClient.findNews(request);

        System.out.println(res.toString());
    }
}