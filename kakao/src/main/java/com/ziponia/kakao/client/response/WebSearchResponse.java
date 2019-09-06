package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class WebSearchResponse implements Serializable {

    private Meta meta;
    private ArrayList<Documents> documents;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Documents> documents) {
        this.documents = documents;
    }

    public static class Documents {
        private String title;
        private String contents;
        private String url;
        private Date datetime;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Date getDatetime() {
            return datetime;
        }

        public void setDatetime(Date datetime) {
            this.datetime = datetime;
        }

        @Override
        public String toString() {
            return "Documents{" +
                    "title='" + title + '\'' +
                    ", contents='" + contents + '\'' +
                    ", url='" + url + '\'' +
                    ", datetime=" + datetime +
                    '}';
        }
    }

    public static class Meta {

        @SerializedName("total_count")
        private Integer totalCount; // 검색어에 검색된 문서수

        @SerializedName("pageable_count")
        private Integer pageableCount; // total_count 중에 노출가능 문서수

        @SerializedName("is_end")
        private Boolean isEnd; // 현재 페이지가 마지막 페이지인지 여부. 값이 false이면 page를 증가시켜 다음 페이지를 요청할 수 있음.

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getPageableCount() {
            return pageableCount;
        }

        public void setPageableCount(Integer pageableCount) {
            this.pageableCount = pageableCount;
        }

        public Boolean getEnd() {
            return isEnd;
        }

        public void setEnd(Boolean end) {
            isEnd = end;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "totalCount=" + totalCount +
                    ", pageableCount=" + pageableCount +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WebSearchResponse{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
