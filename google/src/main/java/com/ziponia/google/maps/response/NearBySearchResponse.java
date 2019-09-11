package com.ziponia.google.maps.response;

import com.ziponia.google.maps.share.Location;
import lombok.Value;

import java.util.List;

@Value
public class NearBySearchResponse {

    private Object[] html_attributions;
    private String next_page_token;
    private List<Result> results;

    @Value
    public static class Result {
        private Geometry geometry;
        private String icon;
        private String id;
        private String name;
        private Opening opening_hours;
        private List<Photo> photos;
        private String place_id;
        private PlusCode plus_code;
        private int price_level;
        private float rating;
        private String reference;
        private String scope;
        private List<String> types;
        private int user_ratings_total;
        private String vicinity;

        @Value
        public static class Geometry {
            private Location location;

            @Value
            public static class Viewport {

                private Location northeast;
                private Location southwest;
            }
        }

        @Value
        public static class Opening {
            private boolean open_now;
        }

        @Value
        public static class Photo {
            private int height;
            private int width;
            private String photo_reference;
        }

        @Value
        public static class PlusCode {
            private String compound_code;
            private String global_code;
        }
    }
}
