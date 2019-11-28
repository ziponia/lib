package com.ziponia.kakao.client.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TranslateRequest {

    private String query;
    private String src_lang;
    private String target_lang;


}
