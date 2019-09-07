package com.ziponia.kakao.client.response;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

import java.util.ArrayList;

@Value
public class TranslateResponse {

    @SerializedName("translated_text")
    private ArrayList<String> translatedText;
}
