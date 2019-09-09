package com.ziponia.iamport;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ziponia.iamport.exception.IamportAuthenticateException;
import com.ziponia.iamport.response.IamportResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

public abstract class IamportBaseClient {

    public static AccessToken ACCESS_TOKEN;

    private static final String BASE_URL = "https://api.iamport.kr";

    private static String REST_KEY;
    private static String SECRET_KEY;

    public IamportRepository iamportClient;

    protected IamportBaseClient(final String restKey, final String secretKey) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder clientBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        iamportClient = clientBuilder.baseUrl(BASE_URL)
                .build().create(IamportRepository.class);

        REST_KEY = restKey;
        SECRET_KEY = secretKey;
    }

    public AccessToken requestToken() {
        Call<IamportResponse<AccessToken>> call = iamportClient.getToken(REST_KEY, SECRET_KEY);

        if (ACCESS_TOKEN == null || ACCESS_TOKEN.getNow() >= ACCESS_TOKEN.getExpired_at()) {
            try {
                System.out.println("Request Token");
                Response<IamportResponse<AccessToken>> res = call.execute();

                if (!res.isSuccessful()) {
                    System.out.println(call.request().url());
                    throw new IamportAuthenticateException("토큰 발급에 실패하였습니다. [imp_key], [imp_secret] 을 확인 해주세요." + res.code());
                }

                if (res.body() == null) {
                    return null;
                }
                ACCESS_TOKEN = res.body().getResponse();
                return ACCESS_TOKEN;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return ACCESS_TOKEN;
    }

    protected Map<String, String> object2Map(Object request) {
        String js = new Gson().toJson(request);
        TypeToken<Map<String, String>> typeToken = new TypeToken<Map<String, String>>() {
        };
        return new Gson().fromJson(js, typeToken.getType());
    }

    protected <T> T exec(Call<T> call) {
        Response<T> res;
        try {
            res = call.execute();
            if (!res.isSuccessful()) {
                System.out.println("Un Successful");
                assert res.body() != null;
                System.out.println(res.body().toString());
            }
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String restKey;
        private String secretKey;

        public Builder restKey(String restKey) {
            this.restKey = restKey;
            return this;
        }

        public Builder secretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        public IamportClient build() {
            return new IamportClient(restKey, secretKey);
        }
    }
}
