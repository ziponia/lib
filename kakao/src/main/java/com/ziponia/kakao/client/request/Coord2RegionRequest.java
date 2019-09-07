package com.ziponia.kakao.client.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coord2RegionRequest {
    private String x;
    private String y;
    private CoordsType input_coord;
    private CoordsType output_coord;
    private String lang;

    public enum CoordsType {WGS84, WCONGNAMUL, CONGNAMUL, WTM, TM}
}
