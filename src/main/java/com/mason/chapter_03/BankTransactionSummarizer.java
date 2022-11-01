package com.mason.chapter_03;

import com.mason.chapter_02.BankTransaction;

/**
 * @author yongshi
 * @date 2022/11/1 22:10
 * @Description TODO
 */
@FunctionalInterface
public interface BankTransactionSummarizer  {
    double summarize(double accumulator, BankTransaction bankTransaction);

}
