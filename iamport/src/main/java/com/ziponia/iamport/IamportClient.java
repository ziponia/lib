package com.ziponia.iamport;

import com.ziponia.iamport.request.BillingKeyRequest;
import com.ziponia.iamport.request.OneTimeRequest;
import com.ziponia.iamport.request.PaymentByBillingKeyRequest;
import com.ziponia.iamport.response.BillingKey;
import com.ziponia.iamport.response.IamportResponse;
import com.ziponia.iamport.response.PaymentResponse;
import retrofit2.Call;

import java.util.Map;

public class IamportClient extends IamportBaseClient {

    protected IamportClient(String restKey, String secretKey) {
        super(restKey, secretKey);
    }

    public IamportResponse<BillingKey> requestBillingKey(BillingKeyRequest request) {
        Map<String, String> query = object2Map(request);
        AccessToken token = requestToken();
        Call<IamportResponse<BillingKey>> call = iamportClient.requestBillingKey(token.getAccess_token(), request.getCustomer_uid(), query);
        return exec(call);
    }

    public IamportResponse<BillingKey> findBillingKey(String customer_uid) {
        AccessToken token = requestToken();
        Call<IamportResponse<BillingKey>> call = iamportClient.findBillingKey(token.getAccess_token(), customer_uid);
        return exec(call);
    }

    public IamportResponse<PaymentResponse> requestPaymentByBillingKey(PaymentByBillingKeyRequest request) {
        Map<String, String> query = object2Map(request);
        AccessToken token = requestToken();
        Call<IamportResponse<PaymentResponse>> call = iamportClient.requestPaymentBillingKey(token.getAccess_token(), query);
        return exec(call);
    }

    public IamportResponse<BillingKey> removeBillingKey(String customer_uid) {
        AccessToken token = requestToken();
        Call<IamportResponse<BillingKey>> call = iamportClient.removeBillingKey(token.getAccess_token(), customer_uid);
        return exec(call);
    }

    public IamportResponse<PaymentResponse> requestPayment(OneTimeRequest request) {
        Map<String, String> query = object2Map(request);
        AccessToken token = requestToken();
        Call<IamportResponse<PaymentResponse>> call = iamportClient.requestPayment(token.getAccess_token(), query);
        return exec(call);
    }
}
