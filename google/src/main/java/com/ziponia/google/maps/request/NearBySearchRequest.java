package com.ziponia.google.maps.request;

import com.ziponia.google.maps.share.PlaceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Locale;

@Getter
@Setter
@Builder
@ToString
public class NearBySearchRequest {

    private String location;
    private RankBy rankBy;

    // 1 ~ 50000
    private Integer radius;

    private Locale language;
    private PlaceType type;

    public enum RankBy {prominence, distance}

    public String getLanguage() {
        return language.getLanguage();
    }
}
