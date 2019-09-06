package com.ziponia.kakao.client.request;

public class WebSearchRequest {

    private String query;
    private Sort sort = Sort.ACCURACY;
    private Integer page;
    private Integer size;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public enum Sort {
        ACCURACY,
        RECENCY
    }
}
