package com.ziponia.google.maps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.google.maps.request.NearBySearchRequest;
import com.ziponia.google.maps.response.NearBySearchResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

public class GoogleMapsClient {
    private static final String BASE_URL = "https://maps.googleapis.com";

    private GoogleMapsRepository googleMapsClient;

    private GoogleMapsClient(final String apiKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new GoogleMapsClientInterceptor(apiKey));
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        googleMapsClient = clientBuilder.baseUrl(BASE_URL)
                .build().create(GoogleMapsRepository.class);
    }

    public NearBySearchResponse nearBySearch(NearBySearchRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<NearBySearchResponse> call = googleMapsClient.nearBySearch(query);
        return exec(call);
    }

    protected  <T> T exec(Call<T> call) {
        Response<T> res;
        try {
            res = call.execute();
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

        public GoogleMapsClient build() {
            return new GoogleMapsClient(apiKey);
        }
    }
}
