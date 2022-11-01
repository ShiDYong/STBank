package com.mason.chapter_03;

import com.mason.chapter_02.BankTransaction;

/**
 * @author yongshi
 * @date 2022/11/1 21:54
 * @Description 接口用来将不同的概念进行解藕，用于将迭代和业务逻辑的概念解藕
 *              这里接口负责选择逻辑
 */
@FunctionalInterface
public interface BankTransactionFilter {
    /**
     * test方法可以访问BankTransaction的所有属性，以指定任何合适的选择条件
     * @param bankTransaction
     * @return
     */
    boolean test(BankTransaction bankTransaction);
}
