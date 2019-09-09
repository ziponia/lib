package com.ziponia.naver.news;

import lombok.Value;

import java.util.List;

@Value
public class NewsResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;

    @Value
    public static class Item {
        private String title;
        private String originallink;
        private String link;
        private String description;
        private String pubDate;
    }
}
