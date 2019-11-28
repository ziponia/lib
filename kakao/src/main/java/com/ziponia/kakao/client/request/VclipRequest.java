package com.ziponia.kakao.client.request;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VclipRequest {
    private String query;
    private Sort sort;
    private Integer page;
    private Integer size;

    public enum Sort {
        @SerializedName("accuracy") ACCURACY,
        @SerializedName("recency") RECENCY
    }
}
