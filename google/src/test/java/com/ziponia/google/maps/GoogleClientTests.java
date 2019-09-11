package com.ziponia.google.maps;

import com.ziponia.google.maps.request.NearBySearchRequest;
import com.ziponia.google.maps.response.NearBySearchResponse;
import com.ziponia.google.maps.share.PlaceType;
import com.ziponia.google.youtube.YoutubeClient;
import com.ziponia.google.youtube.request.SearchRequest;
import com.ziponia.google.youtube.response.SearchResponse;

import java.util.Locale;

class GoogleClientTests {

    private static final String API_KEY = "{your google api key}";

    private static GoogleMapsClient mapsClient;
    private static YoutubeClient youtubeClient;

    public static void main(String[] args) {
        mapsClient = new GoogleMapsClient(API_KEY);
        youtubeClient = new YoutubeClient(API_KEY);

//         nearByPlace();
//        youtubeSearch();
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

    public static void youtubeSearch() {
        SearchRequest request = SearchRequest.builder()
                .part(SearchRequest.Part.SNIPPET)
                .q("미생")
                .type(SearchRequest.Type.CHANNEL)
                .build();
        SearchResponse res = youtubeClient.search(request);

        System.out.println(res.toString());
    }
}