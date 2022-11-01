package com.mason.chapter_03;


import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/11/1 22:12
 * @Description 计算处理的逻辑
 */
public class BankStatementProcessor {

    private List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }


    public SummaryStatistics summaryStatistics() {
        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream().mapToDouble(BankTransaction::getAmount).summaryStatistics();
        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    /**
     * 查找某个月的的银行交易
     */
    public double calculateTotalInMonth(Month month) {
        return summarizeTransactions((acc, bankTransaction) -> bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);


    }


    /**
     * 查找超过一定数额的银行交易方法
     *
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionsGreaterThanEqual(int amount) {
        return findTransaction(bankTransaction -> bankTransaction.getAmount() >= amount);


    }

    public List<BankTransaction> findTransaction(BankTransactionFilter bankTransactionFilter) {
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

}
