package com.ziponia.st11.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductSearchRequest {

    @NonNull
    private String keyword;

    @NonNull
    private Integer pageNum = 1;
    private String pageSize;

    private SortCd sortCd;
    private String option;
    private TargetSearchPrd targetSearchPrd;

    public enum SortCd {CP, A, G, I, L, H, N}
    public enum TargetSearchPrd {ENG, KOR}
}
