package com.ziponia.iamport;

import com.ziponia.iamport.request.BillingKeyRequest;
import com.ziponia.iamport.request.OneTimeRequest;
import com.ziponia.iamport.request.PaymentByBillingKeyRequest;
import com.ziponia.iamport.response.BillingKey;
import com.ziponia.iamport.response.IamportResponse;
import com.ziponia.iamport.response.PaymentResponse;

import java.util.Date;

class IamportClientTest {

    /**
     * 테스트를 하기 위한 프로퍼티
     */
    private static final String merchant_uid = "ORDR-" + new Date().getTime(); // 주문번호
    private static final String card_number = "****-****-****-****"; // 카드번호 dddd-dddd-dddd-dddd
    private static final String birth = "******"; // 생년월일 6자리 또는 사업자번호 10자리
    private static final String expiry = "YYYY-MM"; // 카드만료일 YYYY-MM
    private static final String pwd_2digit = "**"; // 카드비밀번호 앞 2자리
    private static final String customer_uid = "user_id"; // 사용자 UID
    private static final String name = "테스트 결제"; // 주문이름
    private static final double amount = 5000; // 결제금액

    private static IamportClient client;

    public static void main(String[] args) {
        client = IamportClient.builder()
                .restKey("{iamport rest key}") // 아임포트에서 발급 받은, api key
                .secretKey("{iamport secret key}") // 아임포트에서 발급 받은 secret key
                .build();

        // 빌링 키를 발급합니다.
        requestBillingKeyTest();

        // 빌링키를 조회합니다.
        findBillingKeyByCustomerTest();

        // 발급 된 빌링키로 결제를 요청합니다.
        requestPaymentByBillingKeyTest();

        // 발급된 빌링키를 삭제합니다.
        removeBillingKeyTest();

        // 1회용 결제를 요청합니다.
        paymentRequestTest();
    }

    private static void requestBillingKeyTest() {
        BillingKeyRequest request = BillingKeyRequest.builder()
                .card_number(card_number)
                .expiry(expiry)
                .birth(birth)
                .pwd_2digit(pwd_2digit)
                .customer_uid(customer_uid)
                .build();

        IamportResponse<BillingKey> res = client.requestBillingKey(request);

        System.out.println(res.toString());
    }

    private static void findBillingKeyByCustomerTest() {
        IamportResponse<BillingKey> result = client.findBillingKey(customer_uid);
        System.out.println(result.getResponse().toString());
    }

    private static void requestPaymentByBillingKeyTest() {
        PaymentByBillingKeyRequest request = PaymentByBillingKeyRequest.builder()
                .customer_uid(customer_uid)
                .name(name)
                .merchant_uid(merchant_uid)
                .amount(amount)
                .build();
        IamportResponse<PaymentResponse> result = client.requestPaymentByBillingKey(request);
        System.out.println(result.getResponse().toString());
    }

    private static void removeBillingKeyTest() {
        IamportResponse<BillingKey> result = client.removeBillingKey(customer_uid);
        System.out.println(result.getResponse().toString());
    }

    private static void paymentRequestTest() {
        OneTimeRequest payment = OneTimeRequest.builder()
                .amount(amount)
                .merchant_uid(merchant_uid)
                .card_number(card_number) // 카드 정보를 등록합니다.
                .expiry(expiry) // 카드 유효기간을 등록합니다. (YYYY-MM)
                .birth(birth) // 생년월일을 등록합니다.
                .pg(PG.INICIS)
                .name(name)
                .buyer_email("thtjwls@gmail.com")
                .pwd_2digit(pwd_2digit)
                .build();

        IamportResponse<PaymentResponse> result = client.requestPayment(payment);
        System.out.println(result.getResponse().toString());
    }
}