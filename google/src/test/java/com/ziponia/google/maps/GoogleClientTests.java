package com.ziponia.google.maps;

import com.ziponia.google.maps.request.NearBySearchRequest;
import com.ziponia.google.maps.request.PhotosByPlaceRequest;
import com.ziponia.google.maps.response.NearBySearchResponse;
import com.ziponia.google.maps.share.PlaceType;
import com.ziponia.google.youtube.YoutubeClient;
import com.ziponia.google.youtube.request.SearchRequest;
import com.ziponia.google.youtube.response.SearchResponse;

class GoogleClientTests {

    private static final String API_KEY = "{your google api key}";

    private static GoogleMapsClient mapsClient;
    private static YoutubeClient youtubeClient;

    public static void main(String[] args) {
        mapsClient = GoogleMapsClient.builder()
                .apiKey(API_KEY)
                .build();
        youtubeClient = YoutubeClient.builder()
                .apiKey(API_KEY)
                .build();

//         nearByPlace();
//        youtubeSearch();
//        photosByPlace();
    }

    public static void nearByPlace() {
        NearBySearchRequest request = NearBySearchRequest.builder()
                .language("ko")
                .location("37.4538497,126.7396146")
                .radius(3000)
                .rankBy(NearBySearchRequest.RankBy.DISTANCE)
                .type(PlaceType.cafe)
                .pagetoken("CqQCGAEAAK5xGZs51HULn_oYzPfXFhdB2CeSwzCW0pvgpK-ED5sbsbh48SRXnJ66StR4EmaOEakJZ10Ss3OW1I7YcxQ5E1FJVOg1PMSbX5jLKElXn1HgwvWpFN_b3SS4AdTA6rwTlRvQ3FvbRMxeb7GkwcTbx_AI5oFBMRT1lp4CC7mLDtaYaqRNx2HEqlgjj7BNOcdI2KWbFe2WBfEwww48bsIijiP4ohznqgKZGgwwU-acxUiWaj7WhGXQISxooxyT3imqV42S6vB_hLVHrxBTSxt8g2o9rM-uVf2xhXDjSlH54A8c0N_8yc53qp2bAbXZsJ-fmurqbq3_DZMnfh5xv7s5KS4PP29Ja7epR9R60t5eDeGW7K-deEqaJ_2w5StCDB834hIQYn2sxCaz4fzM5x8ru92dfBoUA5TAOfOzPePdA1ghqdMWLR0JlE4")
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

    public static void photosByPlace() {
        PhotosByPlaceRequest request = PhotosByPlaceRequest.builder()
                .maxwidth(400)
                .photoreference("CmRaAAAAcgvY2CpDZ-bdKsMpgmQEmL0sA70tWZfVPdycWvvGL5OopeH_H7PYXwAdeGtggYjZ-WGm_HFh1p4SXpYAYWZ_Qs-UF5V1ycxDazdPN47CawHiNBHaHj1ZRwBJTLcqhRskEhBPKBWnHLAgY_AYvePUew4jGhQ27PcKARd0LdaziaOq8UxjgVqMpA")
                .build();

        String res = mapsClient.photosByPlace(request);
        System.out.println(res);
    }
}