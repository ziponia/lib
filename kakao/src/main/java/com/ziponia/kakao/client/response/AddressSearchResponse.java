package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.util.ArrayList;

@Value
public class AddressSearchResponse {

    private Meta meta;
    private ArrayList<Document> documents;

    @Value
    public static class Meta {

        @SerializedName("total_count")
        private Integer totalCount;

        @SerializedName("pageable_count")
        private Integer pageableCount;

        @SerializedName("is_end")
        private Boolean isEnd;
    }

    @Value
    public static class Document {

        @SerializedName("address_name")
        private String addressName;

        @SerializedName("address_type")
        private AddressType addressType;

        private String x;
        private String y;
        private Address address;

        @SerializedName("road_address")
        private RoadAddress roadAddress;

        public enum AddressType {REGION, ROAD, REGION_ADDR, ROAD_ADDR}

        @Value
        public static class Address {

            @SerializedName("address_name")
            private String addressName;
            @SerializedName("region_1depth_name")
            private String region1depthName;
            @SerializedName("region_2depth_name")
            private String region2depthName;
            @SerializedName("region_3depth_name")
            private String region3depth_name;
            @SerializedName("region_3depth_h_name")
            private String region3depthHNname;
            @SerializedName("h_code")
            private String Hcode;
            @SerializedName("b_code")
            private String bCode;
            @SerializedName("mountain_yn")
            private String mountainYn;
            @SerializedName("main_address_no")
            private String mainAddressNo;
            @SerializedName("sub_address_no")
            private String subAddressNo;
            @SerializedName("zip_code")
            private String zipCode;
            @SerializedName("x")
            private String x;
            @SerializedName("y")
            private String y;
        }

        @Value
        public static class RoadAddress {
            @SerializedName("address_name")
            private String addressName;
            @SerializedName("region_1depth_name")
            private String region1depthName;
            @SerializedName("region_2depth_name")
            private String region2depthName;
            @SerializedName("region_3depth_name")
            private String region3depthName;
            @SerializedName("road_name")
            private String roadName;
            @SerializedName("underground_yn")
            private String undergroundYn;
            @SerializedName("main_building_no")
            private String mainBuildingNo;
            @SerializedName("sub_building_no")
            private String subBuildingNo;
            @SerializedName("building_name")
            private String buildingName;
            @SerializedName("zone_no")
            private String zoneNo;
            @SerializedName("y")
            private String x;
            @SerializedName("x")
            private String y;
        }
    }
}
