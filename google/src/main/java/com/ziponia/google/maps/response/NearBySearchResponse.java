package com.ziponia.google.maps.response;

import com.ziponia.google.maps.share.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NearBySearchResponse {

    private Object[] html_attributions;
    private String next_page_token;
    private List<Result> results;

    @Getter
    @Setter
    @ToString
    public static class Result {
        private Geometry geometry;
        private String icon;
        private String id;
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

        @Getter
        @Setter
        @ToString
        public static class Geometry {
            private Location location;

            @Getter
            @Setter
            @ToString
            public static class Viewport {

                private Location northeast;
                private Location southwest;
            }
        }

        @Getter
        @Setter
        @ToString
        public static class Opening {
            private boolean open_now;
        }

        @Getter
        @Setter
        @ToString
        public static class Photo {
            private int height;
            private int width;
            private String photo_reference;
        }

        public static class PlusCode {
            private String compound_code;
            private String global_code;
        }
    }
}
