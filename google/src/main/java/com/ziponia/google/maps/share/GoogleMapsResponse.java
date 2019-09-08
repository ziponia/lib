package com.ziponia.google.maps.share;

import java.util.List;

public class GoogleMapsResponse<T> {

    private String next_page_token;
    private String status;

    private List<T> results;
}
