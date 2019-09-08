package com.ziponia.google.maps;

import com.ziponia.google.maps.response.NearBySearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface GoogleMapsRepository {

    @GET("/maps/api/place/nearbysearch/json")
    Call<NearBySearchResponse> nearBySearch(
            @QueryMap Map<String, String> query
    );
}
