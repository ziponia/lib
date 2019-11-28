package com.ziponia.kakao.client.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coord2RegionRequest {
    private String x;
    private String y;
    private CoordsType input_coord;
    private CoordsType output_coord;
    private String lang;

    public enum CoordsType {WGS84, WCONGNAMUL, CONGNAMUL, WTM, TM}
}
