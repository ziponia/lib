package com.ziponia.kakao.client.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TranslateRequest {

    private String query;
    private String src_lang;
    private String target_lang;


}
