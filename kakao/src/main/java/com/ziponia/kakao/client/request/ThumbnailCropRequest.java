package com.ziponia.kakao.client.request;

import lombok.*;

import java.io.File;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThumbnailCropRequest {

    private File file;
    private String image_url;

    @NonNull
    private Integer width;

    @NonNull
    private Integer height;
}
