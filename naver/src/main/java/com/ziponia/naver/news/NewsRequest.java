package com.ziponia.naver.news;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class NewsRequest {

    @NonNull
    private String query;

    private Integer display;

    private Integer start;

    private Sort sort;

    public enum Sort {sim, date}
}
