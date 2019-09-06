package com.ziponia.kakao.client;

import com.ziponia.kakao.client.request.WebSearchRequest;
import com.ziponia.kakao.client.response.WebSearchResponse;

public interface KakaoService {
    WebSearchResponse webSearch(WebSearchRequest request);
}
