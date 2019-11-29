package com.ziponia.google.youtube;

import com.ziponia.google.GoogleBaseClient;
import com.ziponia.google.youtube.request.SearchRequest;
import com.ziponia.google.youtube.request.exception.YoutubeClientException;
import com.ziponia.google.youtube.response.SearchResponse;
import retrofit2.Call;

import java.util.Map;

public class YoutubeClient extends GoogleBaseClient {

    public YoutubeClient(String apiKey) {
        super(apiKey);
    }

    public SearchResponse search(SearchRequest request) throws YoutubeClientException {
        Map<String, String> query = object2Map(request);
        Call<SearchResponse> call = youtubeClient.search(query);
        return exec(call);
    }

    @Override
    public <T> T exec(Call<T> call) {
        return super.exec(call);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String apiKey;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public YoutubeClient build() {
            return new YoutubeClient(apiKey);
        }
    }
}
