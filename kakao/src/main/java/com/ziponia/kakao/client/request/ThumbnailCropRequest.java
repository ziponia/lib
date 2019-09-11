package com.ziponia.kakao.client.request;

import lombok.*;
import java.io.File;

@Getter
@Setter
@ToString
@Builder
public class ThumbnailCropRequest {

    @NonNull
    private File file;

    @NonNull
    private Integer width;

    @NonNull
    private Integer height;
}
