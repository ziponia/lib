package com.ziponia.st11;

import com.ziponia.st11.request.ProductInfoRequest;
import com.ziponia.st11.request.ProductSearchRequest;
import com.ziponia.st11.response.ProductInfoResponse;
import com.ziponia.st11.response.ProductSearchResponse;

class St11ClientTest {

    private static St11Client st11Client;

    public static void main(String[] args) {
        st11Client = St11Client.builder()
                .setApiKey("{youre 11st api key}")
                .build();

        productSearch();
        productInfo();
    }

    public static void productSearch() {
        ProductSearchRequest request = new ProductSearchRequest();
        request.setKeyword("test");

        ProductSearchResponse res = st11Client.productSearch(request);

        System.out.println(res.toString());
    }

    public static void productInfo() {
        ProductInfoRequest request = new ProductInfoRequest();
        request.setProductCode("2289777234");
        ProductInfoResponse res = st11Client.productInfo(request);

        System.out.println(res.toString());
    }
}