package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.util.ArrayList;

@Value
public class Coord2RegionResponse {

    private Meta meta;
    private ArrayList<Document> documents;

    @Value
    public static class Meta {
        @SerializedName("total_count")
        private Integer totalCount;
    }

    @Value
    public static class Document {

        @SerializedName("region_type")
        private String region_type;
        @SerializedName("address_name")
        private String address_name;
        @SerializedName("region_1depth_name")
        private String region_1depth_name;
        @SerializedName("region_2depth_name")
        private String region_2depth_name;
        @SerializedName("code")
        private String code;
        @SerializedName("x")
        private String x;
        @SerializedName("region_3depth_name")
        private String region_3depth_name;
        @SerializedName("region_4depth_name")
        private String region_4depth_name;
        @SerializedName("y")
        private String y;

    }
}
