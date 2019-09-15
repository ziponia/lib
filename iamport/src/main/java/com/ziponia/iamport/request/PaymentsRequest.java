package com.ziponia.iamport.request;

import lombok.Getter;

@Getter
public class PaymentsRequest {

    private String[] imp_uid;

    public PaymentsRequest(String[] imp_uid) {
        this.imp_uid = imp_uid;
    }

    public static PaymentRequestBuilder builder() {
        return new PaymentRequestBuilder();
    }

    public static class PaymentRequestBuilder {

        private String[] imp_uid;

        public PaymentRequestBuilder imp_uid(String... imp_uid) {
            this.imp_uid = imp_uid;
            return this;
        }

        public PaymentsRequest build() {
            return new PaymentsRequest(imp_uid);
        }
    }
}
