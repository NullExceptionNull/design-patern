package com.qingyunge.pattern.strategy.pay.payport;

import com.qingyunge.pattern.strategy.pay.PayState;

public interface Payment {
    PayState pay(String uid, double amount);
}
