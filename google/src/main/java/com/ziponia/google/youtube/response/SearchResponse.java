package com.ziponia.google.youtube.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class SearchResponse {

    private String kind;
    private String etag;
    private String nextPageToken;
    private String prevPageToken;
    private PageInfo pageInfo;

    private List<Item> items; // ... TODO

    @Value
    public static class PageInfo {
        private int totalResults;
        private int resultsPerPage;
    }


    @Value
    public static class Item {
        private String kind;
        private String etag;
        private Meta id;
        private Snippet snippet;

        @Value
        public static class Meta {
            private String kind;
            private String vidioId;
        }

        @Value
        public static class Snippet {
            private Date publishedAt;
            private String channelId;
            private String title;
            private String description;
            private String channelTitle;
            private String liveBroadcastContent;

            private Thumbnail thumbnails;

            @Value
            public static class Image {
                private String url;
                private Integer width;
                private Integer height;
            }

            @Value
            public static class Thumbnail {

                @SerializedName("default")
                private Image small;

                private Image medium;
                private Image high;
            }
        }
    }
}
