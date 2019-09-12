package com.ziponia.google.maps.request;

import com.google.gson.annotations.SerializedName;
import com.ziponia.google.maps.share.PlaceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class NearBySearchRequest {

    private String location;
    private RankBy rankBy;

    // 1 ~ 50000
    private Integer radius;

    private String language;
    private PlaceType type;
    private String keyword;

    // 0 ~ 4
    private Integer minprice;

    // 0 ~ 4
    private Integer maxprice;
    private String name;
    private Boolean opennow;
    private String pagetoken;

    public enum RankBy {
        @SerializedName("prominence") PROMINENCE,
        @SerializedName("distance") DISTANCE
    }
}
