package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Value
public class WebSearchResponse implements Serializable {

    private Meta meta;
    private ArrayList<Documents> documents;

    @Value
    public static class Documents {
        private String title;
        private String contents;
        private String url;
        private Date datetime;
    }

    @Value
    public static class Meta {

        @SerializedName("total_count")
        private Integer totalCount; // 검색어에 검색된 문서수

        @SerializedName("pageable_count")
        private Integer pageableCount; // total_count 중에 노출가능 문서수

        @SerializedName("is_end")
        private Boolean isEnd; // 현재 페이지가 마지막 페이지인지 여부. 값이 false이면 page를 증가시켜 다음 페이지를 요청할 수 있음.
    }
}
