package com.qingyunge.pattern.strategy.pay.payport;

public enum PayType {
    ALI_PAY(new Alipay());
    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }
}
