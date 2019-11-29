package com.ziponia.google.maps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.google.GoogleBaseClient;
import com.ziponia.google.maps.request.NearBySearchRequest;
import com.ziponia.google.maps.request.PhotosByPlaceRequest;
import com.ziponia.google.maps.response.NearBySearchResponse;
import retrofit2.Call;

import java.util.Map;

public class GoogleMapsClient extends GoogleBaseClient {

    public GoogleMapsClient(String apiKey) {
        super(apiKey);
    }

    public NearBySearchResponse nearBySearch(NearBySearchRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<NearBySearchResponse> call = googleMapsClient.nearBySearch(query);
        return exec(call);
    }

    public String photosByPlace(PhotosByPlaceRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        StringBuilder builder = new StringBuilder();
        for (String s : query.keySet()) {
            builder
                    .append("&")
                    .append(s)
                    .append("=")
                    .append(query.get(s));
        }
        return BASE_URL_MAPS + "/maps/api/place/photo" + "?key=" + API_KEY + builder.toString();
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
