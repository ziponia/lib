package com.ziponia.iamport;

import com.ziponia.iamport.response.BillingKey;
import com.ziponia.iamport.response.IamportResponse;
import com.ziponia.iamport.response.PaymentResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface IamportRepository {

    @FormUrlEncoded
    @POST("/users/getToken")
    Call<IamportResponse<AccessToken>> getToken(
            @Field("imp_key") String imp_key,
            @Field("imp_secret") String imp_secret
    );

    @FormUrlEncoded
    @POST("/subscribe/customers/{customer_uid}")
    Call<IamportResponse<BillingKey>> requestBillingKey(
            @Header("Authorization") String access_token,
            @Path("customer_uid") String customer_uid,
            @FieldMap Map<String, String> query
    );

    @GET("/subscribe/customers/{customer_uid}")
    Call<IamportResponse<BillingKey>> findBillingKey(
            @Header("Authorization") String access_token,
            @Path("customer_uid") String customer_uid
    );

    @FormUrlEncoded
    @POST("/subscribe/payments/again")
    Call<IamportResponse<PaymentResponse>> requestPaymentBillingKey(
            @Header("Authorization") String access_token,
            @FieldMap Map<String, String> query
    );

    @DELETE("/subscribe/customers/{customer_uid}")
    Call<IamportResponse<BillingKey>> removeBillingKey(
            @Header("Authorization") String access_token,
            @Path("customer_uid") String customer_uid
    );

    @FormUrlEncoded
    @POST("/subscribe/payments/onetime")
    Call<IamportResponse<PaymentResponse>> requestPayment(
            @Header("Authorization") String access_token,
            @FieldMap Map<String, String> query
    );

}
