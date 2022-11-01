package com.mason.chapter_03;

import com.mason.chapter_02.BankTransaction;

import java.time.Month;

/**
 * @author yongshi
 * @date 2022/11/1 22:02
 * @Description 声明一个BankTransactionFilter的实现类
 */
public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000;
    }
}
