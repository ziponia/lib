package com.ziponia.naver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.naver.news.NewsRequest;
import com.ziponia.naver.news.NewsResponse;
import com.ziponia.naver.news.exception.NaverBadRequestException;
import com.ziponia.naver.news.exception.NaverClientException;
import com.ziponia.naver.news.exception.NaverUnAuthorizeException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public class NaverClient extends NaverBaseClient {

    public NaverClient(String clientId, String clientSecret) {
        super(clientId, clientSecret);
    }

    public NewsResponse findNews(NewsRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<NewsResponse> call = naverClient.findNews(
                CLIENT_ID, CLIENT_SECRET, query
        );

        try {
            Response<NewsResponse> res = call.execute();

            if (!res.isSuccessful()) {
                assert res.errorBody() != null;
                String msg = res.errorBody().string();
                System.out.println(msg);
                if (res.code() == 400) {
                    throw new NaverBadRequestException(msg);
                } else if (res.code() == 401) {
                    throw new NaverUnAuthorizeException(msg);
                } else {
                    throw new NaverClientException(msg);
                }
            }

            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
