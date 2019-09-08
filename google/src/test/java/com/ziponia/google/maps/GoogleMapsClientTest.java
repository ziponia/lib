package com.ziponia.google.maps;

import com.ziponia.google.maps.request.NearBySearchRequest;
import com.ziponia.google.maps.response.NearBySearchResponse;
import com.ziponia.google.maps.share.PlaceType;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class GoogleMapsClientTest {

    private static GoogleMapsClient mapsClient;

    public static void main(String[] args) {
        mapsClient = GoogleMapsClient.builder()
                .apiKey("{google maps api key}")
                .build();

        System.out.println(Locale.KOREAN.getLanguage());
        nearByPlace();
    }

    public static void nearByPlace() {
        NearBySearchRequest request = NearBySearchRequest.builder()
                .language(Locale.KOREA)
                .location("37.4538497,126.7396146")
                .radius(3000)
                .rankBy(NearBySearchRequest.RankBy.distance)
                .type(PlaceType.cafe)
                .build();
        NearBySearchResponse res = mapsClient.nearBySearch(request);
        System.out.println(res.toString());
    }
}