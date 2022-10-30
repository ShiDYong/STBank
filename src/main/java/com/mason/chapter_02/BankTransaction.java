package com.mason.chapter_02;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author yongshi
 * @date 2022/10/29 23:05
 * @Description 关于银行交易的领域类
 */
public class BankTransaction {
    //交易发生的实践
    private final LocalDate date;

    //交易发生金额
    private final double amount;

    //交易类型的说明
    private final String description;


    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(date, that.date) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
