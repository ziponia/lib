package com.ziponia.google.youtube.request;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest implements Serializable {

    @NonNull
    private Part part;

    private Boolean forMine;
    private Boolean forContentOwner;
    private Boolean relatedToVideoId;

    private String channelId;
    private ChannelType channelType;
    private EventType eventType;
    private Integer maxResults;
    private String onBehalfOfContentOwner;
    private Order order;
    private String pageToken;
    private Date publishedAfter;
    private Date publishedBefore;
    private String q;
    private String regionCode;
    private SafeSearch safeSearch;
    private String topicId;

    private String type;
    private VideoCaption videoCaption;
    private String videoCategoryId;
    private VideoDefinition videoDefinition;
    private VideoDimension videoDimension;
    private VideoDuration videoDuration;
    private VideoEmbeddable videoEmbeddable;
    private VideoLicense videoLicense;
    private VideoSyndicated videoSyndicated;
    private VideoType videoType;

    public enum Part {
        @SerializedName("id") ID,
        @SerializedName("snippet") SNIPPET
    }

    public enum ChannelType {
        @SerializedName("any") ANY,
        @SerializedName("show") SHOW
    }

    public enum EventType {
        @SerializedName("completed") COMPLETED,
        @SerializedName("live") LIVE,
        @SerializedName("upcoming") UPCOMING
    }

    public enum Order {
        @SerializedName("date") DATE,
        @SerializedName("rating") RATING,
        @SerializedName("relevance") RELEVANCE,
        @SerializedName("title") TITLE,
        @SerializedName("videoCount") VIDEO_COUNT,
        @SerializedName("viewCount") VIEW_COUNT
    }

    public enum SafeSearch {
        @SerializedName("moderate") MODERATE,
        @SerializedName("none") NONE,
        @SerializedName("strict") STRICT
    }

    public enum Type {
        @SerializedName("channel") CHANNEL,
        @SerializedName("playlist") PLAYLIST,
        @SerializedName("video") VIDEO
    }

    public enum VideoCaption {
        @SerializedName("any") ANY,
        @SerializedName("closedCaption") CLOSED_CAPTION,
        @SerializedName("none") NONE
    }

    public enum VideoDefinition {
        @SerializedName("any") ANY,
        @SerializedName("high") HIGH,
        @SerializedName("standard") STANDARD
    }

    public enum VideoDimension {
        @SerializedName("2d") _2D,
        @SerializedName("3d") _3D,
        @SerializedName("any") ANY
    }

    public enum VideoDuration {
        @SerializedName("any") ANY,
        @SerializedName("long") LONG,
        @SerializedName("medium") MEDIUM,
        @SerializedName("short") SHORT;
    }

    public enum VideoEmbeddable {
        @SerializedName("any") ANY,
        @SerializedName("true") TRUE
    }

    public enum VideoLicense {
        @SerializedName("any") ANY,
        @SerializedName("creativeCommon") CREATIVE_COMMON,
        @SerializedName("youtube") YOUTUBE
    }

    public enum VideoSyndicated {
        @SerializedName("any") ANY,
        @SerializedName("true") TRUE
    }

    public enum VideoType {
        @SerializedName("any") ANY,
        @SerializedName("episode") EPISODE,
        @SerializedName("movie") MOVIE
    }

    public static class SearchRequestBuilder {

        public SearchRequestBuilder type(Type... type) {
            StringBuilder builder = new StringBuilder();
            String json = new Gson().toJson(type);
            this.type = json
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll("\"", "");
            return this;
        }
    }
}
