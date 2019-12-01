package com.ziponia.st11;

import com.ziponia.st11.response.ProductInfoResponse;
import com.ziponia.st11.response.ProductSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface St11Repository {

    @GET("/openapi/OpenApiService.tmall?apiCode=ProductSearch")
    Call<ProductSearchResponse> searchProduct(
            @QueryMap Map<String, String> query
    );

    @GET("/openapi/OpenApiService.tmall?apiCode=ProductInfo")
    Call<ProductInfoResponse> productInfo(
            @QueryMap Map<String, String> query
    );
}
