package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.util.List;

@Value
public class TranslateResponse {

    @SerializedName("translated_text")
    private List<List<String>> translatedText;
}
