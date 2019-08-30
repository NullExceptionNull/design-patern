package com.qingyunge.pattern.strategy.pay.payport;

import com.qingyunge.pattern.strategy.pay.PayState;

public class Alipay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",amount);
    }
}
