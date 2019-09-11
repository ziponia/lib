package com.ziponia.google;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.google.maps.GoogleMapsClientInterceptor;
import com.ziponia.google.maps.GoogleMapsRepository;
import com.ziponia.google.youtube.YoutubeRepository;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

public abstract class GoogleBaseClient {

    private static final String BASE_URL_MAPS = "https://maps.googleapis.com";
    private static final String BASE_URL_YOUTUBE = "https://www.googleapis.com";

    public static String API_KEY;

    public GoogleMapsRepository googleMapsClient;
    public YoutubeRepository youtubeClient;

    public GoogleBaseClient(final String apiKey) {
        API_KEY = apiKey;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new GoogleMapsClientInterceptor(apiKey));
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        googleMapsClient = clientBuilder.baseUrl(BASE_URL_MAPS)
                .build().create(GoogleMapsRepository.class);

        youtubeClient = clientBuilder.baseUrl(BASE_URL_YOUTUBE)
                .build().create(YoutubeRepository.class);
    }
    protected Map<String, String> object2Map(Object request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, Object>> typeToken = new TypeToken<Map<String, Object>>() {
        };
        return new Gson().fromJson(js, typeToken.getType());
    }

    public <T> T exec(Call<T> call) {
        Response<T> res;
        try {
            res = call.execute();
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
