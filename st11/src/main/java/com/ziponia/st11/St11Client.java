package com.ziponia.st11;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.st11.request.ProductInfoRequest;
import com.ziponia.st11.request.ProductSearchRequest;
import com.ziponia.st11.response.ProductInfoResponse;
import com.ziponia.st11.response.ProductSearchResponse;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;

import java.io.IOException;
import java.util.Map;

public class St11Client {

    private static final String BASE_URL = "http://openapi.11st.co.kr";

    private St11Repository stClinet;

    private St11Client(final String apiKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl originalHttpUrl = request.url();

                        HttpUrl url = originalHttpUrl.newBuilder()
                                .addQueryParameter("key", apiKey)
                                .build();

                        Request.Builder requestBuilder = request.newBuilder()
                                .url(url);

                        Request newRequest = requestBuilder.build();

                        return chain.proceed(newRequest);
                    }
                });
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(JaxbConverterFactory.create())
                .client(httpClient.build());

        stClinet = clientBuilder.baseUrl(BASE_URL)
                .build().create(St11Repository.class);
    }

    // call api
    public ProductSearchResponse productSearch(ProductSearchRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<ProductSearchResponse> call = stClinet.searchProduct(query);
        return exec(call);
    }

    public ProductInfoResponse productInfo(ProductInfoRequest request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        Map<String, String> query = new Gson().fromJson(js, typeToken.getType());
        Call<ProductInfoResponse> call = stClinet.productInfo(query);
        return exec(call);
    }

    private <T> T exec(Call<T> call) {
        try {
            Response<T> res = call.execute();
            return res.body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String apiKey;

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public St11Client build() {
            return new St11Client(apiKey);
        }
    }
}
