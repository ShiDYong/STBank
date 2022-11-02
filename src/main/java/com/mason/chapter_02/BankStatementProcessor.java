package com.mason.chapter_02;


import java.time.Month;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/30 11:18
 * @Description :这里是将BankStatementAnalyzerSRP类的计算操作提起成一个新的类
 * ，因为这些操作都共享了交易方法的参数列表，因此将其作为字段包含到类中
 * 使类具有更高的内聚性
 */
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * 计算交易总额的方法
     * @return
     */
    public double calculateTotalAmount() {
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;

    }

    /**
     * 按照月统计的交易总额的方法
     * @param month
     * @return
     */
    public double calculateTotalInMonth(Month month){
       double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }

        }
        return total;

    }

    /**
     * 按照交易类型统计总额的方法
     * @param category
     * @return
     */
    public double calculateTotalForCategory(String category){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }


    /**
     * 通过上面的方法可以看出：BankStatementProcessor中的方法可以被运用程序的其他部分重用，而不需要以来于整个BankStatementAnalyzer类
     */











}
