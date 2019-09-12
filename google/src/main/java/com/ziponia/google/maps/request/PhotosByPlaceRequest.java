package com.ziponia.google.maps.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PhotosByPlaceRequest {

    private String photoreference;
    private Integer maxwidth;
    private Integer maxheight;
}
