package com.ziponia.kakao.client.response;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class VclipResponse {

    private Meta meta;
    private List<Document> documents;

    @Value
    public static class Meta {
        private Integer total_count;
        private Integer pageable_count;
        private boolean is_end;
    }

    @Value
    public static class Document {
        private String title;
        private Integer play_time;
        private String thumbnail;
        private String url;
        private String author;
        private Date datetime;
    }
}
